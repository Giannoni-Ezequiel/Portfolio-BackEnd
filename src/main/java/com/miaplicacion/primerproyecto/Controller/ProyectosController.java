package com.miaplicacion.primerproyecto.Controller;

import com.miaplicacion.primerproyecto.Entity.DTO.ProyectoDTO;
import com.miaplicacion.primerproyecto.Entity.Proyectos;
import com.miaplicacion.primerproyecto.Seguridad.Controller.Mensaje;
import com.miaplicacion.primerproyecto.Service.ProyectosService;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proyectos")
public class ProyectosController 
{
    private final ProyectosService proyectoService;
    @Autowired
    public ProyectosController(ProyectosService proyectoService)
    {
        this.proyectoService = proyectoService;
    }
    
    @GetMapping("")
    public ResponseEntity<List<Proyectos>> listar()
    {
        List<Proyectos> list = proyectoService.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Proyectos> listadId(@PathVariable("id")Long id)
    {
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyectos proyecto = proyectoService.listadId(id);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
    
    @PostMapping(value = "add")
    public ResponseEntity<?> add(@RequestBody ProyectoDTO proyecto)
    {
        // if(StringUtils.isBlank(proyecto.getNombre())) // Uncomment this after adding getNombre() to ProyectoDTO
        //     return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        proyectoService.add(proyecto);
        return new ResponseEntity<>(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody ProyectoDTO proyecto)
    {
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        // if(StringUtils.isBlank(proyecto.getNombre())) // Uncomment this after adding getNombre() to ProyectoDTO
        //     return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        proyectoService.edit(proyecto);
        return new ResponseEntity<>(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id")Long id)
    {
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        proyectoService.delete(id);
        return new ResponseEntity<>(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
}
