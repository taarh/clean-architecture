package com.clean.rh.usercase.personne;

import com.clean.rh.entity.Personne;

import java.util.Optional;

public interface PersonneRepository {

    Optional<Personne> creer(Personne personne);
    Optional<Personne> recupererPersonneByEmail(String email);
}
