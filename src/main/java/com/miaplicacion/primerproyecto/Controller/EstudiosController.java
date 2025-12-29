package com.miaplicacion.primerproyecto.Controller;

//import org.springframework.web.bind.annotation.CrossOrigin;
import com.miaplicacion.primerproyecto.Entity.DTO.EstudioDTO;
import com.miaplicacion.primerproyecto.Entity.Estudios;
import com.miaplicacion.primerproyecto.Seguridad.Controller.Mensaje;
import com.miaplicacion.primerproyecto.Service.EstudiosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudio")
public class EstudiosController 
{
    private final EstudiosService estudioService;
    @Autowired
    public EstudiosController(EstudiosService estudioService){
        this.estudioService = estudioService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Estudios>> list(){
        List<Estudios> list = this.estudioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudios> getById(@PathVariable("id") Long id){
        if(!this.estudioService.existsById(id.intValue())) // Assuming service needs int
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Estudios estudios = this.estudioService.getOne(id.intValue()).get(); // Assuming service needs int
        return new ResponseEntity(estudios, HttpStatus.OK);
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody EstudioDTO estudios){
        if(StringUtils.isBlank(estudios.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                    HttpStatus.BAD_REQUEST);
        if(this.estudioService.existsBynombre(estudios.getNombre()))
            return new ResponseEntity(new Mensaje("Esa Estudio existe"),
                    HttpStatus.BAD_REQUEST);
        Estudios est = new Estudios(estudios.getTitulo()
                ,estudios.getNombre(), estudios.getFecha_inicio(),estudios.getFecha_fin()
                , estudios.getImg(), estudios.getDescripcion(),
                estudios.toEstudioEntity().getPersona());
        this.estudioService.save(est);

        return new ResponseEntity(new Mensaje("Estudio Agregada"), HttpStatus.OK);
    }
    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EstudioDTO estudio)
    {
        if(!this.estudioService.existsById(id.intValue())) // Assuming service needs int
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(this.estudioService.existsBynombre(estudio.getNombre()) &&
                this.estudioService.getByNombre(estudio.getNombre()).get().getId() != id.intValue()) // Assuming service needs int
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"),
                    HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(estudio.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                    HttpStatus.BAD_REQUEST);
        Estudios est = this.estudioService.getOne(id.intValue()).get(); // Assuming service needs int
        est.setTitulo(estudio.getTitulo());
        est.setNombre(estudio.getNombre());
        est.setFecha_inicio(estudio.getFecha_inicio());
        est.setFecha_fin(estudio.getFecha_fin());
        est.setImg(estudio.getImg());
        est.setDescripcion(estudio.getDescripcion());
        est.setPersona(estudio.toEstudioEntity().getPersona());

        this.estudioService.save(est);
        return new ResponseEntity(new Mensaje("Estudio actualizada"),
                HttpStatus.OK);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id)
    {
        if(!this.estudioService.existsById(id.intValue())) // Assuming service needs int
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        this.estudioService.delete(id);

        return new ResponseEntity(new Mensaje("Estudio eliminada"), HttpStatus.OK);

    }
}
