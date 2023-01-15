package com.miaplicacion.primerproyecto.Controller;

//import org.springframework.web.bind.annotation.CrossOrigin;
import com.miaplicacion.primerproyecto.Entity.DTO.ProyectoDTO;
import com.miaplicacion.primerproyecto.Entity.Proyectos;
import com.miaplicacion.primerproyecto.Service.ProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "https://proyectoangulareg.web.app/")
@RequestMapping("proyectos")
public class ProyectosController 
{
    private final ProyectosService proyectoService;
    @Autowired
    public ProyectosController(ProyectosService proyectoService){
        this.proyectoService = proyectoService;
    }
    
    @GetMapping("")
    public List<Proyectos> listar(){
        return this.proyectoService.listar();
    }
    
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody ProyectoDTO proyecto){
        this.proyectoService.add(proyecto);
    }
    
    @PutMapping(value = "id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Proyectos editar(@RequestBody ProyectoDTO proyecto, @PathVariable("id")
    int id){
        return this.proyectoService.edit(proyecto);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public Proyectos delete(@PathVariable("id")Long id){
        return this.proyectoService.delete(id);
    }
    
    @GetMapping(path = {"/{id}"})
    public Proyectos listadId(@PathVariable("id")Long id){
        return this.proyectoService.listadId(id);
    }
}
