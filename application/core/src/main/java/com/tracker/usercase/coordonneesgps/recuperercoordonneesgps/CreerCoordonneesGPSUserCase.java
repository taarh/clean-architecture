package com.tracker.usercase.coordonneesgps.recuperercoordonneesgps;

import com.tracker.entity.PositionGps;
import com.tracker.usercase.coordonneesgps.PositionGpsRepository;

import java.util.Optional;

public class CreerCoordonneesGPSUserCase {

    private final PositionGpsRepository positionGpsRepository;

    public CreerCoordonneesGPSUserCase(PositionGpsRepository positionGpsRepository) {
        this.positionGpsRepository = positionGpsRepository;
    }

    public PositionGps creerCoordonneesGPS(PositionGps positionGPS) {
        Optional<PositionGps> optionaPositionGPS = positionGpsRepository.creerPositionGps(positionGPS);
        return optionaPositionGPS.get();

    }

}
