package com.miaplicacion.primerproyecto.Seguridad.dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class Jwt 
{
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    public Jwt(String token, String nombreUsuario, 
            Collection<? extends GrantedAuthority> authorities) 
    {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        return authorities;
    }

    
}
