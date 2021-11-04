package com.clean.rh.entrypoints.rest.personne;

import com.clean.rh.entity.Personne;
import com.clean.rh.usercase.personne.RecupererPersonneUserCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RecupererPersonneEndpoint {
    public static final String API_PATH = "/getPersonne";

    private static final Logger LOGGER = LoggerFactory.getLogger(RecupererPersonneEndpoint.class);

    private final RecupererPersonneUserCase recupererPersonneUserCase;

    public RecupererPersonneEndpoint(RecupererPersonneUserCase getPersonneUserCase) {
        this.recupererPersonneUserCase = getPersonneUserCase;
    }


    @GetMapping(value = API_PATH + "/{email}")
    public PersonnePresenter recupererPersonneParEmail(@PathVariable String email) {
        LOGGER.info(" sauvguarder la personne : {}");
        Personne personne = recupererPersonneUserCase.recupererPersonneParEmail(email);
        return PersonnePresenter.convertirEnPersonnePresenter(personne);
    }
}
