package com.tracker.usercase.personne;

import com.tracker.entity.Personne;

import java.util.Optional;

public interface PersonneRepository {

    Optional<Personne> creer(Personne personne);
    Optional<Personne> recupererPersonneByEmail(String email);
}
