package com.clean.rh.usercase.personne;

import com.clean.rh.entity.Personne;
import com.clean.rh.usercase.personne.exception.PersonneNonTrouveException;

import java.util.Optional;

public class RecupererPersonneUserCase {

    private PersonneRepository personneRepository;

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
