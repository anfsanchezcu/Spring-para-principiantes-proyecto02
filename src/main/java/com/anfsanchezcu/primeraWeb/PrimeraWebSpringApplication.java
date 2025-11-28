package com.anfsanchezcu.primeraWeb;

import com.anfsanchezcu.primeraWeb.entities.Persona;
import com.anfsanchezcu.primeraWeb.respository.PersonaRepository;
import com.anfsanchezcu.primeraWeb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PrimeraWebSpringApplication  implements CommandLineRunner {

	@Autowired
	private PersonaService personaService; //automaticamente se llama a su implementacion a pesar de solo llamar a la implementacion

	public static void main(String[] args) {
		SpringApplication.run(PrimeraWebSpringApplication.class, args);
	}


	public void run(String... args ) throws Exception{
		personaService.createPerson(new Persona(4L,"Andres", 12));
		personaService.createPerson(new Persona(2L,"Grabriel", 12));
		personaService.createPerson(new Persona(3L,"Lukas", 12));

		System.out.println("personas en tabla" + personaService.countPersons());

		List<Persona> personas = personaService.getAll();
		personas.forEach(personaAux -> System.out.println(personaAux.getNombre()));

	}


}
