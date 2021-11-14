package com.tracker.usercase.coordonneesgps.recuperercoordonneesgps;

import com.tracker.entity.PositionGps;

import java.util.Optional;

public interface RecupererCoordonneesGPSProvider {
    Optional<PositionGps> recupererCoordonneesGPSParMatricule(String matricule);

}
