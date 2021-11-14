package com.clean.rh.entrypoints.rest.recuperercoordonneesgps;

import com.clean.rh.usercase.coordonneesgps.emettrecoordonneesgps.EmettreCoordonneesGPSUserCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmettreCoordonneesGpsEndpoint {

    public static final String API_PATH = "/sendgps";

    private static final Logger LOGGER = LoggerFactory.getLogger(RecupererCoordonneesGpsEndpoint.class);

    private final EmettreCoordonneesGPSUserCase emettreCoordonneesGPSUserCase;

    public EmettreCoordonneesGpsEndpoint(EmettreCoordonneesGPSUserCase emettreCoordonneesGPSUserCase) {
        this.emettreCoordonneesGPSUserCase = emettreCoordonneesGPSUserCase;
    }

    @PostMapping(value = API_PATH)
    public void emettreCoordonneesGPSParMatricule(@RequestBody CoordonneesGpsPresenter coordonneesGpsPresenter) {
        LOGGER.info("vehicule avec matricule  {} envoies ses coordoonées GPS: {}: {}",coordonneesGpsPresenter.getMatricule(), coordonneesGpsPresenter.getLatitude(), coordonneesGpsPresenter.getLongitude());
        emettreCoordonneesGPSUserCase.emettreCoordonneesGPS(CoordonneesGpsPresenter.convertirEnPositionGps(coordonneesGpsPresenter));
    }

}
