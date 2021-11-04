package com.clean.rh.entrypoints.rest.personne;


import com.clean.rh.entity.Personne;
import com.clean.rh.usercase.personne.CreerPersonneUserCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class CreerPersonneEndpoint {

    public static final String API_PATH = "/insererPersonne";

    private static final Logger LOGGER = LoggerFactory.getLogger(CreerPersonneEndpoint.class);

    private final CreerPersonneUserCase creerPersonneUserCase;

    public CreerPersonneEndpoint(CreerPersonneUserCase creerPersonneUserCase) {
        this.creerPersonneUserCase = creerPersonneUserCase;
    }


    @PostMapping(value = API_PATH)
    public PersonnePresenter inserer( @RequestBody PersonnePresenter personnePresenter) {
        LOGGER.info(" sauvguarder la personne : {}");
        Optional<Personne> personne = creerPersonneUserCase.ceerPersonne(PersonnePresenter.convertirEnPersonne(personnePresenter));
        if (personne.isPresent()) {
            return PersonnePresenter.convertirEnPersonnePresenter(personne.get());
        } else {
            return new PersonnePresenter();
        }
    }
}
