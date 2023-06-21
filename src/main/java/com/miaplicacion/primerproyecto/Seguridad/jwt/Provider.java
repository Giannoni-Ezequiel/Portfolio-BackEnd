package com.miaplicacion.primerproyecto.Seguridad.jwt;

import com.miaplicacion.primerproyecto.Seguridad.Entity.UsuarioPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class Provider 
{
    private final static Logger logger = LoggerFactory.getLogger(Provider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication)
    {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        List<String> roles = usuarioPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public String getNombreUsuarioFromToken(String token)
    {
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token)
    {
        try 
        {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            return true;
        }
        catch (MalformedJwtException e)
        {
            logger.error("token mal formado");
        }
        catch (UnsupportedJwtException e)
        {
            logger.error("token no soportado");
        }
        catch (ExpiredJwtException e)
        {
            logger.error("token expirado");
        }
        catch (IllegalArgumentException e)
        {
            logger.error("token vacío");
        }
        catch (SignatureException e)
        {
            logger.error("fail en la firma");
        }
        return false;
    }
}