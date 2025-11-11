package com.miaplicacion.primerproyecto.Controller;


import com.miaplicacion.primerproyecto.Entity.DTO.ExperienciaDTO;
import com.miaplicacion.primerproyecto.Entity.Experiencia;
import com.miaplicacion.primerproyecto.Seguridad.Controller.Mensaje;
import com.miaplicacion.primerproyecto.Service.ExperienciaService;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController 
{
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experiencia>> list()
    {
        List<Experiencia> list = experienciaService.list();
            return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id)
    {
        if(!experienciaService.existsById(id.intValue())) // Assuming service still needs int, but ideally this should be Long
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id.intValue()).get(); // Assuming service still needs int
            return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }
    
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody ExperienciaDTO experiencia){
        if(StringUtils.isBlank(experiencia.getNombreEmpresa()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"),
                HttpStatus.BAD_REQUEST);
        if(experienciaService.existsBynombreEmpresa(experiencia.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"),
                    HttpStatus.BAD_REQUEST);
                Experiencia exp = new Experiencia(experiencia.getCargo()
                ,experiencia.getDescripcion(), experiencia.getFecha_fin()
                , experiencia.getFecha_inicio(),experiencia.getNombreEmpresa()
                , experiencia.toExperienciaEntity().getPersona());
                experienciaService.save(exp);
            return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }
    
    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ExperienciaDTO experiencia)
    {
        if(!this.experienciaService.existsById(id.intValue())) // Assuming service needs int
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(this.experienciaService.existsBynombreEmpresa(experiencia.getNombreEmpresa()) &&
        this.experienciaService.getByNombreEmpresa(experiencia.getNombreEmpresa()).get().getId() != id.intValue()) // Assuming service needs int
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"),
                    HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experiencia.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                    HttpStatus.BAD_REQUEST);
                Experiencia exp = this.experienciaService.getOne(id.intValue()).get(); // Assuming service needs int
                exp.setNombreEmpresa(experiencia.getNombreEmpresa());
                exp.setCargo(experiencia.getCargo());
                exp.setDescripcion(experiencia.getDescripcion());
                exp.setFecha_fin(experiencia.getFecha_fin());
                exp.setFecha_inicio(experiencia.getFecha_inicio());
                exp.setPersona(experiencia.toExperienciaEntity().getPersona());
                this.experienciaService.save(exp);
            return new ResponseEntity(new Mensaje("Experiencia actualizada"),
                HttpStatus.OK);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id)
    {
        if(!this.experienciaService.existsById(id.intValue())) // Assuming service needs int
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
                this.experienciaService.delete(id);
            return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

}
