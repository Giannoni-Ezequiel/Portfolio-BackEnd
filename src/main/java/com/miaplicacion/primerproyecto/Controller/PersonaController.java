package com.miaplicacion.primerproyecto.Controller;

import com.miaplicacion.primerproyecto.Entity.Persona;
import com.miaplicacion.primerproyecto.Service.IPersonaService;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://ezequiel-giannoni.web.app")
@RestController
@CrossOrigin(origins = "https://ezequiel-giannoni.web.app/")
@RequestMapping("persona")
public class PersonaController {
    
    /*List<Persona> listaPersonas = new ArrayList();
    
    @GetMapping ("/hola/{nombre}")
    public String decirHola(@PathVariable String nombre){
        return "Hola mundo" + nombre;
    }
    
    @GetMapping ("/chau")
    public String decirChau (@RequestParam String nombre) {
        return "Chau mundo " + nombre;
            }
    */
    @Autowired
    private IPersonaService persoServ;
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/crear")
    public void agregarPersona(@RequestBody Persona pers)
    {
        //listaPersonas.add(pers);
        persoServ.crearPersona(pers);
    }
    
    @GetMapping ("/ver")
    @ResponseBody
    public List<Persona> verPersonas ()
    {
        //return listaPersonas;
        return persoServ.verPersonas();
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona(@PathVariable Long id)
    {
        persoServ.borrarPersona(id);
    }
    
    @GetMapping("/traer/{id}")
    public Persona buscarPersona(@PathVariable Long id)
    {
        return persoServ.buscarPersona(id);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona)
    {
        Persona  updatePersona = persoServ.updatePersona(persona);
        return new ResponseEntity<>(updatePersona, HttpStatus.OK);
    }
}

