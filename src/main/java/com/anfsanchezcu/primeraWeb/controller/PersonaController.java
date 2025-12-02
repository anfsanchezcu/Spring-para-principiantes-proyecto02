package com.anfsanchezcu.primeraWeb.controller;

import com.anfsanchezcu.primeraWeb.entities.Persona;
import com.anfsanchezcu.primeraWeb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/nueva")
    public String NuevaPersona(Model model){
        model.addAttribute("persona",new Persona());
        model.addAttribute("nueva", "/personas/nueva");
        return "nuevaPersonaForm";
    }

    @PostMapping("/nueva")
    public String GuardarPersona(@ModelAttribute Persona persona){
        personaService.createPerson(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{id}")
    public String editarPersona(@PathVariable Long id,@ModelAttribute Persona persona, Model model){
        model.addAttribute("persona",persona);
        model.addAttribute("accion","/personas/editar"+id);
        return "nuevaPersonaForm";
    }

    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona, Model model){
        personaService.updatePerson(id,persona);
        return "redirect:/personas";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id){
        personaService.deletePerson(id);
        return "redirect:/personas";
    }
}
