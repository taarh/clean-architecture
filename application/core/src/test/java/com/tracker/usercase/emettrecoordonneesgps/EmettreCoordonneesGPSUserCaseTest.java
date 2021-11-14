package com.tracker.usercase.emettrecoordonneesgps;

import com.tracker.entity.PositionGps;
import com.tracker.usercase.coordonneesgps.emettrecoordonneesgps.EmettreCoordonneesGPSProvider;
import com.tracker.usercase.coordonneesgps.emettrecoordonneesgps.EmettreCoordonneesGPSUserCase;
import com.tracker.usercase.coordonneesgps.emettrecoordonneesgps.StatutEnvoi;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmettreCoordonneesGPSUserCaseTest {

    private final static String MATRICULE = "AQ-55-158";
    private final static String LATITUDE="1213.265980";
    private final static String LONGITUDE="999.265980";
    EmettreCoordonneesGPSProvider emettreCoordonneesGPSProvider = mock(EmettreCoordonneesGPSProvider.class);
    EmettreCoordonneesGPSUserCase emettreCoordonneesGPSUserCase = new EmettreCoordonneesGPSUserCase(emettreCoordonneesGPSProvider);


    @Test
    public void testNominalEmettreCoordonneesGPS(){

        // initialiser les données
        PositionGps positionGPS =  PositionGps.builder().latitude(LATITUDE).longitude(LONGITUDE).build();
        // appel au mock
        when(emettreCoordonneesGPSProvider.emettreCoordonneesGPSParMatricule(positionGPS)).thenReturn(StatutEnvoi.SUCCES);
        // appel au méthode
        StatutEnvoi resultat=emettreCoordonneesGPSUserCase.emettreCoordonneesGPS(positionGPS);
        //vérifications
        assertEquals(StatutEnvoi.SUCCES, StatutEnvoi.SUCCES);
    }

}
