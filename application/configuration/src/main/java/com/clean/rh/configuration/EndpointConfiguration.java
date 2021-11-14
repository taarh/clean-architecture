package com.clean.rh.configuration;

import com.clean.rh.entrypoints.rest.exception.GestionnaireException;
import com.clean.rh.entrypoints.rest.personne.CreerPersonneEndpoint;
import com.clean.rh.entrypoints.rest.personne.RecupererPersonneEndpoint;
import com.clean.rh.entrypoints.rest.recuperercoordonneesgps.EmettreCoordonneesGpsEndpoint;
import com.clean.rh.entrypoints.rest.recuperercoordonneesgps.RecupererCoordonneesGpsEndpoint;
import com.clean.rh.usercase.coordonneesgps.emettrecoordonneesgps.EmettreCoordonneesGPSUserCase;
import com.clean.rh.usercase.personne.CreerPersonneUserCase;
import com.clean.rh.usercase.personne.RecupererPersonneUserCase;
import com.clean.rh.usercase.coordonneesgps.recuperercoordonneesgps.RecupererCoordonneesGPSUserCase;
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
