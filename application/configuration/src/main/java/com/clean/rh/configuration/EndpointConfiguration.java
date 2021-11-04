package com.clean.rh.configuration;

import com.clean.rh.entrypoints.rest.personne.CreerPersonneEndpoint;
import com.clean.rh.entrypoints.rest.personne.RecupererPersonneEndpoint;
import com.clean.rh.usercase.personne.CreerPersonneUserCase;
import com.clean.rh.usercase.personne.RecupererPersonneUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

    @Bean
    public CreerPersonneEndpoint creerPersonneEndpoint(CreerPersonneUserCase creerPersonneUserCase) {
        return new CreerPersonneEndpoint(creerPersonneUserCase);
    }

    @Bean
    public RecupererPersonneEndpoint getPersonneEndpoint(RecupererPersonneUserCase recupererPersonneUserCase) {
        return new RecupererPersonneEndpoint(recupererPersonneUserCase);
    }
}
