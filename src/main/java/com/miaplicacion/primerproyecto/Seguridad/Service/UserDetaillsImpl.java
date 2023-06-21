package com.miaplicacion.primerproyecto.Seguridad.Service;

import com.miaplicacion.primerproyecto.Seguridad.Entity.Usuario;
import com.miaplicacion.primerproyecto.Seguridad.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetaillsImpl implements UserDetailsService 
{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) 
            throws UsernameNotFoundException 
    {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}
