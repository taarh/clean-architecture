package com.clean.rh.integration.database.personne;


import com.clean.rh.dataproviders.database.personne.PersonneDataBaseProvider;
import com.clean.rh.entity.Personne;
import com.clean.rh.integration.database.DatabaseIntegrationTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonneDatabaseIntegrationTest extends DatabaseIntegrationTest {

    public static final String PERSONNE_NOM = "arhalai";
    public static final String PERSONNE_PRENOM = "taoufik";
    public static final String PERSONNE_EMAIL = "arhalai@gmail.com";
    public static final int PERSONNE_AGE = 20;

    @Autowired
    PersonneDataBaseProvider personneDataBaseProvider;


    @Before
    public void setUp() {
        cleanUpDatabase();
    }


    @Test
    public void recupererPersonneDetail() throws Exception {
        etantDonnneUnePersonne(PERSONNE_EMAIL);

        Optional<Personne> personne = personneDataBaseProvider.recupererPersonneByEmail(PERSONNE_EMAIL);

        assertThat(personne.get().getAge()).isEqualTo(20);

    }


    private void etantDonnneUnePersonne(String email) {
        Personne personne =Personne.builder().nom(PERSONNE_NOM).prenom(PERSONNE_PRENOM).age(PERSONNE_AGE).email(email).build();
        personneDataBaseProvider.creer(personne);
    }




}
