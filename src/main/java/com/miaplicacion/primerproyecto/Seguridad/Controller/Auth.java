package com.miaplicacion.primerproyecto.Seguridad.Controller;

import com.miaplicacion.primerproyecto.Seguridad.Entity.Rol;
import com.miaplicacion.primerproyecto.Seguridad.Entity.Usuario;
import com.miaplicacion.primerproyecto.Seguridad.Enums.RolNombre;
import com.miaplicacion.primerproyecto.Seguridad.Service.RolService;
import com.miaplicacion.primerproyecto.Seguridad.Service.UsuarioService;
import com.miaplicacion.primerproyecto.Seguridad.dto.Jwt;
import com.miaplicacion.primerproyecto.Seguridad.dto.LoginUsuario;
import com.miaplicacion.primerproyecto.Seguridad.dto.NuevoUsuario;
import com.miaplicacion.primerproyecto.Seguridad.jwt.Provider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class Auth {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    Provider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return new ResponseEntity
        (new Mensaje("campos mal puestos o email inválido"), 
                HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity
        (new Mensaje("ese nombre ya existe"), 
                HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity
        (new Mensaje("ese email ya existe"), 
                HttpStatus.BAD_REQUEST);
        Usuario usuario =
        new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
            passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity
        (new Mensaje("usuario guardado"), 
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Jwt> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity
        (new Mensaje("campos mal puestos"), 
                HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        Jwt jwtDto = new Jwt(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}