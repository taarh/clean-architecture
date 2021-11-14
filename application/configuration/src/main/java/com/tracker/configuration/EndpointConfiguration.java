package com.tracker.configuration;

import com.tracker.entrypoints.rest.exception.GestionnaireException;
import com.tracker.entrypoints.rest.personne.CreerPersonneEndpoint;
import com.tracker.entrypoints.rest.personne.RecupererPersonneEndpoint;
import com.tracker.entrypoints.rest.recuperercoordonneesgps.EmettreCoordonneesGpsEndpoint;
import com.tracker.entrypoints.rest.recuperercoordonneesgps.RecupererCoordonneesGpsEndpoint;
import com.tracker.usercase.coordonneesgps.emettrecoordonneesgps.EmettreCoordonneesGPSUserCase;
import com.tracker.usercase.personne.CreerPersonneUserCase;
import com.tracker.usercase.personne.RecupererPersonneUserCase;
import com.tracker.usercase.coordonneesgps.recuperercoordonneesgps.RecupererCoordonneesGPSUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

    @Bean
    public CreerPersonneEndpoint creerPersonneEndpoint(CreerPersonneUserCase creerPersonneUserCase) {
        return new CreerPersonneEndpoint(creerPersonneUserCase);
    }

    @Bean
    public RecupererPersonneEndpoint recupererPersonneEndpoint(RecupererPersonneUserCase recupererPersonneUserCase) {
        return new RecupererPersonneEndpoint(recupererPersonneUserCase);
    }
    @Bean
    public RecupererCoordonneesGpsEndpoint recupererCoordonneesGpsEndpoint(RecupererCoordonneesGPSUserCase recupererCoordonneesGPSUserCase) {
        return new RecupererCoordonneesGpsEndpoint(recupererCoordonneesGPSUserCase);
    }

    @Bean
    public EmettreCoordonneesGpsEndpoint emettreCoordonneesGpsEndpoint(EmettreCoordonneesGPSUserCase emettreCoordonneesGPSUserCase) {
        return new EmettreCoordonneesGpsEndpoint(emettreCoordonneesGPSUserCase);
    }

    @Bean
    public GestionnaireException gestionnaireException(){
        return new GestionnaireException();
    }
}
