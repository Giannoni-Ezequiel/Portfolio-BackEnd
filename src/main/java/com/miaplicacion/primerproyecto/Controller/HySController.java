package com.miaplicacion.primerproyecto.Controller;

//import org.springframework.web.bind.annotation.CrossOrigin;
import com.miaplicacion.primerproyecto.Entity.DTO.HySDTO;
import com.miaplicacion.primerproyecto.Entity.HyS;
import com.miaplicacion.primerproyecto.Service.HySService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "https://proyectoangulareg.web.app/")
@RequestMapping("hys")
public class HySController 
{
     private final HySService hysService;
    @Autowired
    public HySController(HySService hysService){
        this.hysService = hysService;
    }
    
    @GetMapping("")
    public List<HyS> listar(){
        return this.hysService.listar();
    }
    
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody HySDTO hys){
        this.hysService.add(hys);
    }
    
    @PutMapping(value = "id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HyS editar(@RequestBody HySDTO hys, @PathVariable("id")
    int id){
        return this.hysService.edit(hys);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public HyS delete(@PathVariable("id")Long id){
        return this.hysService.delete(id);
    }
    
    @GetMapping(path = {"/{id}"})
    public HyS listadId(@PathVariable("id")Long id){
        return this.hysService.listadId(id);
    }
}
