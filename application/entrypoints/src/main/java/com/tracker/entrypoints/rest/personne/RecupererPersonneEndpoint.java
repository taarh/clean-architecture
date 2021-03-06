package com.tracker.entrypoints.rest.personne;

import com.tracker.entity.Personne;
import com.tracker.entrypoints.rest.exception.NonTrouveException;
import com.tracker.usercase.personne.RecupererPersonneUserCase;
import com.tracker.usercase.personne.exception.PersonneNonTrouveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
        LOGGER.info("recuperer Personne par mail  : {}",email);
        try {
            Personne personne = recupererPersonneUserCase.recupererPersonneParEmail(email);
            return PersonnePresenter.convertirEnPersonnePresenter(personne);
        }catch(PersonneNonTrouveException e){
            LOGGER.info("Aucune personne trouvé avec ce mail",email);
            throw new NonTrouveException("Personne non trouvé");
        }
    }
}
