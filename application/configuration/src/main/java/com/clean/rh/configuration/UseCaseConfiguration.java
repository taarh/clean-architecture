package com.clean.rh.configuration;

import com.clean.rh.usercase.coordonneesgps.emettrecoordonneesgps.EmettreCoordonneesGPSProvider;
import com.clean.rh.usercase.coordonneesgps.emettrecoordonneesgps.EmettreCoordonneesGPSUserCase;
import com.clean.rh.usercase.coordonneesgps.PositionGpsRepository;
import com.clean.rh.usercase.personne.PersonneRepository;
import com.clean.rh.usercase.personne.CreerPersonneUserCase;
import com.clean.rh.usercase.personne.RecupererPersonneUserCase;
import com.clean.rh.usercase.coordonneesgps.recuperercoordonneesgps.RecupererCoordonneesGPSUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreerPersonneUserCase creerPersonneUserCase(PersonneRepository personneRepository) {
        return new CreerPersonneUserCase(personneRepository);
    }

    @Bean
    public RecupererPersonneUserCase recupererPersonneUserCase(PersonneRepository personneRepository) {
        return new RecupererPersonneUserCase(personneRepository);
    }

    @Bean
    public RecupererCoordonneesGPSUserCase recupererCoordonneesGPSUserCase(PositionGpsRepository positionGpsRepository) {
        return new RecupererCoordonneesGPSUserCase(positionGpsRepository);
    }

    @Bean
    public EmettreCoordonneesGPSUserCase emettreCoordonneesGPSUserCase(EmettreCoordonneesGPSProvider emettreCoordonneesGPSProvider) {
        return new EmettreCoordonneesGPSUserCase(emettreCoordonneesGPSProvider);
    }







}
