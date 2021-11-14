package com.tracker.usercase.personne;

import com.tracker.entity.Personne;

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
