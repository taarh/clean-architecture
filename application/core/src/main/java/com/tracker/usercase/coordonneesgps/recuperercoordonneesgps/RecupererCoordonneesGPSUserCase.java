package com.tracker.usercase.coordonneesgps.recuperercoordonneesgps;

import com.tracker.entity.PositionGps;
import com.tracker.usercase.coordonneesgps.PositionGpsRepository;

import java.util.Collections;
import java.util.List;

public class RecupererCoordonneesGPSUserCase {

    private final PositionGpsRepository positionGpsRepository;

    public RecupererCoordonneesGPSUserCase(PositionGpsRepository positionGpsRepository) {
        this.positionGpsRepository = positionGpsRepository;
    }

    public List<PositionGps> recupererCoordonneesGPS(String matricule) {

        List<PositionGps> PositionGPSs = positionGpsRepository.recupererPositionGpsParMatricule(matricule);
        if (!PositionGPSs.isEmpty()) {
            return PositionGPSs;
        }
        return Collections.emptyList();

    }

}
