package com.miaplicacion.primerproyecto.Entity;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "experiencia")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Proyectos 
{
    @Id
    @SequenceGenerator(
            name= "proyectos_sequence",
            sequenceName = "proyectos_sequence",
            allocationSize = 1,
            initialValue = 0)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "proyectos_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "github")
    private String github;
    @Column(name = "img")
    private String img;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "proyecto")
    private String proyecto;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "persona_fk")
    private Persona persona;

    public Proyectos(String descripcion, Date fecha, String github, String img, String nombre, String proyecto, Persona persona) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.github = github;
        this.img = img;
        this.nombre = nombre;
        this.proyecto = proyecto;
        this.persona = persona;
    }

   
    
}
