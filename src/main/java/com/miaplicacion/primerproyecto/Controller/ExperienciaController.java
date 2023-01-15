package com.miaplicacion.primerproyecto.Controller;

//import org.springframework.web.bind.annotation.CrossOrigin;
import com.miaplicacion.primerproyecto.Entity.DTO.ExperienciaDTO;
import com.miaplicacion.primerproyecto.Entity.Experiencia;
import com.miaplicacion.primerproyecto.Service.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "https://proyectoangulareg.web.app/")
@RequestMapping("experiencia")
public class ExperienciaController 
{
     private final ExperienciaService experienciaService;
    @Autowired
    public ExperienciaController(ExperienciaService experienciaService){
        this.experienciaService = experienciaService;
    }
    
    @GetMapping("")
    public List<Experiencia> listar(){
        return this.experienciaService.listar();
    }
    
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody ExperienciaDTO experiencia){
        this.experienciaService.add(experiencia);
    }
    
    @PutMapping(value = "id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Experiencia editar(@RequestBody ExperienciaDTO experiencia, @PathVariable("id")
    int id){
        return this.experienciaService.edit(experiencia);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public Experiencia delete(@PathVariable("id")Long id){
        return this.experienciaService.delete(id);
    }
    
    @GetMapping(path = {"/{id}"})
    public Experiencia listadId(@PathVariable("id")Long id){
        return this.experienciaService.listadId(id);
    }
}
