package com.tracker.usercase.personne;

import com.tracker.entity.Personne;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


public class CreerPersonneUserCaseTest {

    private final static String EMAIL="arhalai@gmail.com";
    PersonneRepository personneRepository = mock(PersonneRepository.class);
    CreerPersonneUserCase creerPersonneUserCase=new CreerPersonneUserCase(personneRepository);



    @Test
    public void testNominalPersonneCreer() {
       Personne personne= Personne
               .builder()
               .age(10)
               .email(EMAIL)
               .prenom("taoufik")
               .nom("arhalai")
               .build();

       when(personneRepository.creer(personne)).thenReturn(Optional.of(personne));

       Optional<Personne>  resultat= creerPersonneUserCase.ceerPersonne(personne);

        assertTrue(resultat.get().equals(personne));


   }

}
