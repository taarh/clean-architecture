package com.clean.rh.usercase;

import com.clean.rh.entity.Personne;
import com.clean.rh.usercase.personne.PersonneRepository;
import com.clean.rh.usercase.personne.RecupererPersonneUserCase;
import com.clean.rh.usercase.personne.exception.PersonneNonTrouveException;
import org.junit.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RecupererPersonneUserCaseTest {

    private final static String EMAIL = "arhalai@gmail.com";
    PersonneRepository personneRepository = mock(PersonneRepository.class);
    RecupererPersonneUserCase recupererPersonneUserCase = new RecupererPersonneUserCase(personneRepository);


    @Test
    public void testNominalRecupererPersonne() {

        Personne personne = Personne
                .builder()
                .age(10)
                .email("arhalai@gmail.com")
                .prenom("taoufik")
                .nom("arhalai")
                .build();

        when(personneRepository.recupererPersonneByEmail(EMAIL)).thenReturn(Optional.of(personne));

        Personne resultat = recupererPersonneUserCase.recupererPersonneParEmail(EMAIL);

        assertEquals(personne, resultat);

    }

    @Test
    public void testPersonneNoTrouveException() {
        when(personneRepository.recupererPersonneByEmail(EMAIL)).thenReturn(Optional.empty());
        assertThrows(PersonneNonTrouveException.class, () -> {
            recupererPersonneUserCase.recupererPersonneParEmail(EMAIL);
        });
    }


}
