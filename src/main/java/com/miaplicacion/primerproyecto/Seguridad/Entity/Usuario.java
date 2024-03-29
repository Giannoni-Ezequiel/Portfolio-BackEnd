package com.miaplicacion.primerproyecto.Seguridad.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
//import lombok.Data;

@Entity
@Table(name="usuario")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Data //genera Get Y Setters
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String email;
    @NotNull
    private String password;
    
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", 
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, 
                    @NotNull String email, @NotNull String password) 
    {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getNombreUsuario() 
    {
        return nombreUsuario;
    }

    public String getEmail() 
    {
        return email;
    }


    public String getPassword() 
    {
        return password;
    }


    public Set<Rol> getRoles() 
    {
        return roles;
    }

    public void setRoles(Set<Rol> roles) 
    {
        this.roles = roles;
    }
    
}
