package com.miaplicacion.primerproyecto.Entity;

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
public class HyS 
{
    @Id
    @SequenceGenerator(
            name= "hys_sequence",
            sequenceName = "hys_sequence",
            allocationSize = 1,
            initialValue = 0)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hys_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "img")
    private String img;
    @Column(name = "porcentaje")
    private Double porcentaje;
    @Column(name = "skill")
    private String skill;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "persona_fk")
    private Persona persona;

    public HyS(String img, Double porcentaje, String skill, Persona persona) {
        this.img = img;
        this.porcentaje = porcentaje;
        this.skill = skill;
        this.persona = persona;
    }
}
