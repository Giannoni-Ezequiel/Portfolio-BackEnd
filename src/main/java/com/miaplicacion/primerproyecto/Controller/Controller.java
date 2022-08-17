package com.miaplicacion.primerproyecto.Controller;

import com.miaplicacion.primerproyecto.model.Persona;
import com.miaplicacion.primerproyecto.service.IPersonaService;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    
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
    
    
    
    @PostMapping ("/personas/crear")
    public void agregarPersona (@RequestBody Persona pers) {
        //listaPersonas.add(pers);
        persoServ.crearPersona(pers);
       
                }
    
    @GetMapping ("/personas/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas (){
        //return listaPersonas;
        return persoServ.verPersonas();
    }
    
    @DeleteMapping ("/personas/delete/{id}")
    public void borrarPersona (@PathVariable Long id) {
        persoServ.borrarPersona(id);
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona buscarPersona(){
        return persoServ.buscarPersona((long)1);
    }
}

