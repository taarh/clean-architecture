package com.tracker.usercase.coordonneesgps;

import com.tracker.entity.PositionGps;

import java.util.List;
import java.util.Optional;

public interface PositionGpsRepository {

    Optional<PositionGps> creerPositionGps(PositionGps positionGps);
    List<PositionGps> recupererPositionGpsParMatricule(String matricule);
}
