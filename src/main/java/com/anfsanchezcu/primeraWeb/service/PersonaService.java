package com.anfsanchezcu.primeraWeb.service;

import com.anfsanchezcu.primeraWeb.entities.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> getAll();
    Optional<Persona> getPerson(Long id);
    Persona createPerson(Persona persona);
    Optional<Persona> updatePerson (Long id, Persona persona);
    Long countPersons();
    void deletePerson(Long id);
}
