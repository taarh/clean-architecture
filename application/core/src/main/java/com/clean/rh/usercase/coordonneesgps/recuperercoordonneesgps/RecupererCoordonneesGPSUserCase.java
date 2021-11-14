package com.clean.rh.usercase.coordonneesgps.recuperercoordonneesgps;

import com.clean.rh.entity.PositionGps;
import com.clean.rh.usercase.coordonneesgps.PositionGpsRepository;

import java.util.Collections;
import java.util.List;

public class RecupererCoordonneesGPSUserCase {

    private PositionGpsRepository positionGpsRepository;

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
