package com.clean.rh.usercase.coordonneesgps.recuperercoordonneesgps;

import com.clean.rh.entity.PositionGps;
import com.clean.rh.usercase.coordonneesgps.PositionGpsRepository;

import java.util.Optional;

public class CreerCoordonneesGPSUserCase {

    private PositionGpsRepository positionGpsRepository;

    public CreerCoordonneesGPSUserCase(PositionGpsRepository positionGpsRepository) {
        this.positionGpsRepository = positionGpsRepository;
    }

    public PositionGps creerCoordonneesGPS(PositionGps positionGPS) {
        Optional<PositionGps> optionaPositionGPS = positionGpsRepository.creerPositionGps(positionGPS);
        return optionaPositionGPS.get();

    }

}
