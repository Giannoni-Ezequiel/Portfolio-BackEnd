package com.miaplicacion.primerproyecto.Controller;

//import org.springframework.web.bind.annotation.CrossOrigin;
import com.miaplicacion.primerproyecto.Entity.DTO.EstudioDTO;
import com.miaplicacion.primerproyecto.Entity.Estudios;
import com.miaplicacion.primerproyecto.Service.EstudiosService;
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
@RequestMapping("estudio")
public class EstudiosController 
{
    private final EstudiosService estudioService;
    @Autowired
    public EstudiosController(EstudiosService estudioService){
        this.estudioService = estudioService;
    }
    
    @GetMapping("")
    public List<Estudios> listar(){
        return this.estudioService.listar();
    }
    
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody EstudioDTO estudio){
        this.estudioService.add(estudio);
    }
    
    @PutMapping(value = "id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Estudios editar(@RequestBody EstudioDTO estudio, @PathVariable("id")
    int id){
        return this.estudioService.edit(estudio);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public Estudios delete(@PathVariable("id")Long id){
        return this.estudioService.delete(id);
    }
    
    @GetMapping(path = {"/{id}"})
    public Estudios listadId(@PathVariable("id")Long id){
        return this.estudioService.listadId(id);
    }
}
