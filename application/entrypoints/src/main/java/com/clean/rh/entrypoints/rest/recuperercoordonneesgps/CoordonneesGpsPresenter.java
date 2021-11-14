package com.clean.rh.entrypoints.rest.recuperercoordonneesgps;

import com.clean.rh.entity.PositionGps;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Data
public class CoordonneesGpsPresenter {
    private String matricule;
    private String latitude;
    private String longitude;
    private LocalDateTime dateEnregistrementPosition;


    public static CoordonneesGpsPresenter convertirEnCoordonneesGpsPresenter(PositionGps positionGPS) {
        CoordonneesGpsPresenter coordonneesGpsPresenter = new CoordonneesGpsPresenter();
        coordonneesGpsPresenter.latitude = positionGPS.getLatitude();
        coordonneesGpsPresenter.longitude = positionGPS.getLongitude();
        coordonneesGpsPresenter.matricule=positionGPS.getMatricule();
        coordonneesGpsPresenter.dateEnregistrementPosition=positionGPS.getDateEnregistrementPosition();

        return coordonneesGpsPresenter;
    }

    public static PositionGps convertirEnPositionGps(CoordonneesGpsPresenter coordonneesGpsPresenter) {

        return PositionGps.builder().latitude(coordonneesGpsPresenter.latitude).longitude(coordonneesGpsPresenter.longitude).matricule(coordonneesGpsPresenter.getMatricule()).dateEnregistrementPosition(LocalDateTime.now()).build();

    }


}
