package com.tracker.usercase.personne;

import com.tracker.entity.Personne;
import com.tracker.usercase.personne.exception.PersonneNonTrouveException;

import java.util.Optional;

public class RecupererPersonneUserCase {

    private final PersonneRepository personneRepository;

    public RecupererPersonneUserCase(PersonneRepository personneRepository) {
        this.personneRepository=personneRepository;
    }

    public Personne recupererPersonneParEmail(String email) {
        Optional <Personne> personne=personneRepository.recupererPersonneByEmail(email);
        if(personne.isEmpty()) {
            throw new PersonneNonTrouveException();
        }
        return personne.get();
    }
}
