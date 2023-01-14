package com.miaplicacion.primerproyecto.Entity;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "estudio")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Estudios {
    @Id
    @SequenceGenerator(
            name= "estudio_sequence",
            sequenceName = "estudio_sequence",
            allocationSize = 1,
            initialValue = 0)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "estudio_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_fin")
    private Date fecha_fin;
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;
    @Column(name = "img")
    private String img;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "titulo")
    private String titulo;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "persona_fk")
    private Persona persona;

    public Estudios(String descripcion, Date fecha_fin, Date fecha_inicio, 
            String img, String nombre, String titulo, Persona persona) {
        this.descripcion = descripcion;
        this.fecha_fin = fecha_fin;
        this.fecha_inicio = fecha_inicio;
        this.img = img;
        this.nombre = nombre;
        this.titulo = titulo;
        this.persona = persona;
    }
    
    
}
