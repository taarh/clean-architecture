package com.clean.rh.usercase.coordonneesgps.emettrecoordonneesgps;

import com.clean.rh.entity.PositionGps;

public class EmettreCoordonneesGPSUserCase {

    private EmettreCoordonneesGPSProvider emettreCoordonneesGPSProvider;

    public EmettreCoordonneesGPSUserCase(EmettreCoordonneesGPSProvider emettreCoordonneesGPSProvider) {
        this.emettreCoordonneesGPSProvider = emettreCoordonneesGPSProvider;
    }

    public StatutEnvoi emettreCoordonneesGPS(PositionGps positionGps) {
       return emettreCoordonneesGPSProvider.emettreCoordonneesGPSParMatricule(positionGps);
    }

}
