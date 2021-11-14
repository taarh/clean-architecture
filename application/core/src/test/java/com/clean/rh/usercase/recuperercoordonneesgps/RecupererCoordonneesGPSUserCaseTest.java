package com.clean.rh.usercase.recuperercoordonneesgps;

import com.clean.rh.entity.PositionGps;
import com.clean.rh.usercase.coordonneesgps.PositionGpsRepository;
import com.clean.rh.usercase.coordonneesgps.recuperercoordonneesgps.RecupererCoordonneesGPSUserCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecupererCoordonneesGPSUserCaseTest {

    private final static String MATRICULE = "AQ-55-158";
    private final static String LATITUDE="1213.265980";
    private final static String LONGITUDE="999.265980";
    PositionGpsRepository positionGpsRepository = mock(PositionGpsRepository.class);
    RecupererCoordonneesGPSUserCase recupererCoordonneesGPSUserCase = new RecupererCoordonneesGPSUserCase(positionGpsRepository);

    @Test
    public void testNominalRecupererCoordonneesGPS(){

       // initialiser les données
       PositionGps positionGPS =  PositionGps.builder().latitude(LATITUDE).longitude(LONGITUDE).build();
       // appel au mock
       when(positionGpsRepository.recupererPositionGpsParMatricule(MATRICULE)).thenReturn(Arrays.asList(positionGPS));
       // appel au méthode
        List<PositionGps> resultat=recupererCoordonneesGPSUserCase.recupererCoordonneesGPS(MATRICULE);
        //vérifications
        assertEquals(resultat.get(0),positionGPS);
    }

}
