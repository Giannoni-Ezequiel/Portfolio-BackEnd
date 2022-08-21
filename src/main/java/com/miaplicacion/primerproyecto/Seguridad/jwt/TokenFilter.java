package com.miaplicacion.primerproyecto.Seguridad.jwt;

import com.miaplicacion.primerproyecto.Seguridad.Service.UserDetaillsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenFilter extends OncePerRequestFilter 
{

    private final static Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Autowired
    Provider jwtProvider;

    @Autowired
    UserDetaillsImpl userDetailsService;

    @Override
    protected void doFilterInternal
        (HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) 
        throws ServletException, IOException 
        {
        try {
            String token = getToken(req);
            if(token != null && jwtProvider.validateToken(token))
            {
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken
                            (userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } 
        catch (Exception e)
        {
            logger.error("fail en el método doFilter " + e.getMessage());
        }
        filterChain.doFilter(req, res);
    }

    private String getToken(HttpServletRequest request)
    {
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;
    }
}
