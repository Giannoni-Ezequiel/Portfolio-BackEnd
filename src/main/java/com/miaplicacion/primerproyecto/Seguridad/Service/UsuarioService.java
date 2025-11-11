package com.miaplicacion.primerproyecto.Seguridad.Service;

import com.miaplicacion.primerproyecto.Seguridad.Entity.Usuario;
import com.miaplicacion.primerproyecto.Seguridad.Repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miaplicacion.primerproyecto.Seguridad.dto.UsuarioDTO;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioService 
{
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario)
    {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario)
    {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email)
    {
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario)
    {
        usuarioRepository.save(usuario);
    }
    
    public List<UsuarioDTO> list() {
    List<Usuario> usuarios = usuarioRepository.findAll();
    return usuarios.stream()
            .map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getRoles()))
            .collect(Collectors.toList());
}
}
