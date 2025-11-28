package com.anfsanchezcu.primeraWeb.respository;

import com.anfsanchezcu.primeraWeb.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
//JpaRepository nos sirve para usar metodos de save, update, delete en la bbdd. Es decir interactua directamente con la base de datos.
}

