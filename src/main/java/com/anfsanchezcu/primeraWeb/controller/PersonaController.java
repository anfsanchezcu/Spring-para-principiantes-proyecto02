package com.anfsanchezcu.primeraWeb.controller;

import com.anfsanchezcu.primeraWeb.entities.Persona;
import com.anfsanchezcu.primeraWeb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public String listarPersonas(Model model){
        //La clase model se utiliza para transferir objetos del controlador a la vista

        List<Persona> personas= personaService.getAll();
        model.addAttribute("personasLista", personas);


        return "listar";
        //el return me dice en este caso el nombre del archivo html que se debe buscar en la carpeta de templates para mostrar la info
    }
}
