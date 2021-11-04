package com.clean.rh.usercase.personne;

import com.clean.rh.entity.Personne;

import java.util.Optional;

public class CreerPersonneUserCase {

    private final PersonneRepository personneRepository;

    public CreerPersonneUserCase(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public Optional<Personne> ceerPersonne (Personne personne){

         return personneRepository.creer(personne);
    }

}
