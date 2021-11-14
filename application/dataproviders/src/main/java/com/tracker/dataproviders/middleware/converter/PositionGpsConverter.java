package com.tracker.dataproviders.middleware.converter;

import com.tracker.dataproviders.middleware.entities.PositionGpsK;
import com.tracker.entity.PositionGps;

public final class PositionGpsConverter {

    private  PositionGpsConverter(){

    }

    public  static PositionGps convertirEnPositionGps(PositionGpsK positionGpsK){
        return  PositionGps.builder().longitude(positionGpsK.getLongitude()).latitude(positionGpsK.getLatitude()).matricule(positionGpsK.getMatricule()).dateEnregistrementPosition(positionGpsK.getDateEnregistrementPosition()).build();
    }
    public  static PositionGpsK convertirEnPositionGpsK(PositionGps positionGPS){
        PositionGpsK positionGpsK = new PositionGpsK();
        positionGpsK.setLatitude(positionGPS.getLatitude());
        positionGpsK.setLongitude(positionGPS.getMatricule());
        positionGpsK.setMatricule(positionGPS.getLongitude());
        positionGpsK.setDateEnregistrementPosition(positionGPS.getDateEnregistrementPosition());

        return positionGpsK;
    }
}
