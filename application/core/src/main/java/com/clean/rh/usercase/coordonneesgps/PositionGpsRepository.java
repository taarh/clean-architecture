package com.clean.rh.usercase.coordonneesgps;

import com.clean.rh.entity.PositionGps;

import java.util.List;
import java.util.Optional;

public interface PositionGpsRepository {

    Optional<PositionGps> creerPositionGps(PositionGps positionGps);
    List<PositionGps> recupererPositionGpsParMatricule(String matricule);
}
