package com.anfsanchezcu.primeraWeb.service.impl;

import com.anfsanchezcu.primeraWeb.entities.Persona;
import com.anfsanchezcu.primeraWeb.respository.PersonaRepository;
import com.anfsanchezcu.primeraWeb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> getPerson(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public Persona createPerson(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Optional<Persona> updatePerson(Long id, Persona persona) {
        Optional<Persona> personaBBDD = personaRepository.findById(id);

        if(personaBBDD.isEmpty())Optional.empty();

        Persona personaAux = personaBBDD.get();
        personaAux.setNombre(personaAux.getNombre());
        personaAux.setEdad(personaAux.getEdad());

        return Optional.of(personaRepository.save(personaAux));
    }

    @Override
    public void deletePerson(Long id) {
        Optional<Persona> personaAux = personaRepository.findById(id);
        if(!personaAux.isEmpty())
            personaRepository.deleteById(id);
    }

    @Override
    public Long countPersons(){
        return personaRepository.count();
    }
}
