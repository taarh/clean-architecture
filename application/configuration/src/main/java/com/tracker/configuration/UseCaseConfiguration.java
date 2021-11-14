package com.tracker.configuration;

import com.tracker.usercase.coordonneesgps.emettrecoordonneesgps.EmettreCoordonneesGPSProvider;
import com.tracker.usercase.coordonneesgps.emettrecoordonneesgps.EmettreCoordonneesGPSUserCase;
import com.tracker.usercase.coordonneesgps.PositionGpsRepository;
import com.tracker.usercase.personne.PersonneRepository;
import com.tracker.usercase.personne.CreerPersonneUserCase;
import com.tracker.usercase.personne.RecupererPersonneUserCase;
import com.tracker.usercase.coordonneesgps.recuperercoordonneesgps.RecupererCoordonneesGPSUserCase;
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
