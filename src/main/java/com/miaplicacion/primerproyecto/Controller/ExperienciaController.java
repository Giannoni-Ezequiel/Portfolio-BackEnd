package com.miaplicacion.primerproyecto.Controller;

//import org.springframework.web.bind.annotation.CrossOrigin;
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


//
@RestController
//@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://ezequiel-giannoni.web.app")
@RequestMapping("/experiencia")
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
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id)
    {
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
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
    
    @PutMapping(value = "id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editar(@RequestBody ExperienciaDTO experiencia, @PathVariable("id")
    long id)
    {
        if(!this.experienciaService.existsById((int) id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(this.experienciaService.existsBynombreEmpresa(experiencia.getNombreEmpresa()) &&
        this.experienciaService.getByNombreEmpresa(experiencia.getNombreEmpresa()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"),
                    HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experiencia.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                    HttpStatus.BAD_REQUEST);
                Experiencia exp = this.experienciaService.getOne((int) id).get();
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
    public ResponseEntity<?> delete(@PathVariable("id")int id)
    {
        if(!this.experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
                this.experienciaService.delete((long) id);
            return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

}
