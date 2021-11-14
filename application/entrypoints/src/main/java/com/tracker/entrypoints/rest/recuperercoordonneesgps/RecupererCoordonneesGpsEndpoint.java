package com.tracker.entrypoints.rest.recuperercoordonneesgps;

import com.tracker.entity.PositionGps;
import com.tracker.entrypoints.rest.exception.NonTrouveException;
import com.tracker.usercase.coordonneesgps.recuperercoordonneesgps.RecupererCoordonneesGPSUserCase;
import com.tracker.usercase.coordonneesgps.exception.PositionGPSNonTrouveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecupererCoordonneesGpsEndpoint {
    public static final String API_PATH = "/getgps";

    private static final Logger LOGGER = LoggerFactory.getLogger(RecupererCoordonneesGpsEndpoint.class);

    private final RecupererCoordonneesGPSUserCase recupererCoordonneesGPSUserCase;

    public RecupererCoordonneesGpsEndpoint(RecupererCoordonneesGPSUserCase recupererCoordonneesGPSUserCase) {
        this.recupererCoordonneesGPSUserCase = recupererCoordonneesGPSUserCase;
    }


    @GetMapping(value = API_PATH + "/{matricule}")
    public List<CoordonneesGpsPresenter> recupererCoordonneesGPSParMatricule(@PathVariable String matricule) {
        LOGGER.info("recuperer position du vehicule avec matricule  : {}", matricule);
        try {
            List<PositionGps> positionGPSs = recupererCoordonneesGPSUserCase.recupererCoordonneesGPS(matricule);
           return  positionGPSs.stream().map(CoordonneesGpsPresenter::convertirEnCoordonneesGpsPresenter).collect(Collectors.toList());
        } catch (PositionGPSNonTrouveException e) {
            LOGGER.info("Position non trouvé avec cette matricule", matricule);
            throw new NonTrouveException("GPS non trouvé");
        }
    }
}
