package com.clean.rh.configuration;

import com.clean.rh.usercase.personne.PersonneRepository;
import com.clean.rh.usercase.personne.CreerPersonneUserCase;
import com.clean.rh.usercase.personne.RecupererPersonneUserCase;
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

}
