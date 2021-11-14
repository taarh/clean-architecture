package com.clean.rh.usercase.coordonneesgps.recuperercoordonneesgps;

import com.clean.rh.entity.PositionGps;

import java.util.Optional;

public interface RecupererCoordonneesGPSProvider {
    Optional<PositionGps> recupererCoordonneesGPSParMatricule(String matricule);

}
