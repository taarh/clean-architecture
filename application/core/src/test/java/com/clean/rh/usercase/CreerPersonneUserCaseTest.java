package com.clean.rh.usercase;

import com.clean.rh.entity.Personne;
import com.clean.rh.usercase.personne.PersonneRepository;
import com.clean.rh.usercase.personne.CreerPersonneUserCase;
import org.junit.Test;

import javax.swing.text.html.Option;
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
