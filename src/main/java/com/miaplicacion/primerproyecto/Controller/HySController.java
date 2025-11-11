package com.miaplicacion.primerproyecto.Controller;

import com.miaplicacion.primerproyecto.Entity.DTO.HySDTO;
import com.miaplicacion.primerproyecto.Entity.HyS;
import com.miaplicacion.primerproyecto.Seguridad.Controller.Mensaje;
import com.miaplicacion.primerproyecto.Service.HySService;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hys")
@CrossOrigin(origins = "http://localhost:4200")
public class HySController 
{
    private final HySService hysService;
    @Autowired
    public HySController(HySService hysService)
    {
        this.hysService = hysService;
    }
    
    @GetMapping("")
    public ResponseEntity<List<HyS>> listar()
    {
        List<HyS> list = hysService.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<HyS> listadId(@PathVariable("id")Long id)
    {
        if(!hysService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        HyS hys = hysService.listadId(id);
        return new ResponseEntity<>(hys, HttpStatus.OK);
    }
    
    @PostMapping(value = "add")
    public ResponseEntity<?> add(@RequestBody HySDTO hys)
    {
        // if(StringUtils.isBlank(hys.getNombre())) // Uncomment this after adding getNombre() to HySDTO
        //     return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        hysService.add(hys);
        return new ResponseEntity<>(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody HySDTO hys)
    {
        if(!hysService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        // if(StringUtils.isBlank(hys.getNombre())) // Uncomment this after adding getNombre() to HySDTO
        //     return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
        hysService.edit(hys);
        return new ResponseEntity<>(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id")Long id)
    {
        if(!hysService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        hysService.delete(id);
        return new ResponseEntity<>(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
}
