package com.tracker.usercase.coordonneesgps.emettrecoordonneesgps;

import com.tracker.entity.PositionGps;

public class EmettreCoordonneesGPSUserCase {

    private final EmettreCoordonneesGPSProvider emettreCoordonneesGPSProvider;

    public EmettreCoordonneesGPSUserCase(EmettreCoordonneesGPSProvider emettreCoordonneesGPSProvider) {
        this.emettreCoordonneesGPSProvider = emettreCoordonneesGPSProvider;
    }

    public StatutEnvoi emettreCoordonneesGPS(PositionGps positionGps) {
       return emettreCoordonneesGPSProvider.emettreCoordonneesGPSParMatricule(positionGps);
    }

}
