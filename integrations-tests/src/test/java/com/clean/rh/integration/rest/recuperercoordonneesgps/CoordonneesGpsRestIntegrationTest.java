package com.clean.rh.integration.rest.recuperercoordonneesgps;

import com.clean.rh.entity.PositionGps;
import com.clean.rh.entrypoints.rest.recuperercoordonneesgps.RecupererCoordonneesGpsEndpoint;
import com.clean.rh.integration.rest.RestIntegrationTest;
import com.clean.rh.usercase.coordonneesgps.recuperercoordonneesgps.RecupererCoordonneesGPSUserCase;
import org.json.JSONException;
import org.junit.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ContextConfiguration(classes = {RestIntegrationTest.class})
@WebMvcTest(RecupererCoordonneesGpsEndpoint.class)
public class CoordonneesGpsRestIntegrationTest extends RestIntegrationTest {
    public static final String API_PATH = "/getgps";
    private static final String MATRICULE = "AQ-04-1478";
    private static final String LATITUDE = "147.258";
    private static final String LONGITUDE = "18.258";



    private static final Logger LOGGER = LoggerFactory.getLogger(CoordonneesGpsRestIntegrationTest.class);
    @MockBean
    private RecupererCoordonneesGPSUserCase recupererCoordonneesGPSUserCase;
    @Autowired
    MockMvc mockMvc;
    String responseContent;
    int responseStatusCode;

    @Test
    public void testRecupererPositonGps() throws Exception {
        etantDonneUnePositionGPS();

        quandRecupererCoordonneesGpsApiEstAppele();

        positionGpsEstRetourne();
    }

    private void quandRecupererCoordonneesGpsApiEstAppele() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(RecupererCoordonneesGpsEndpoint.API_PATH + "/{matricule}", MATRICULE)).andReturn();
        responseContent = mvcResult.getResponse().getContentAsString();
        responseStatusCode = mvcResult.getResponse().getStatus();
    }

    private void etantDonneUnePositionGPS() {
        PositionGps positionGPS = PositionGps
                .builder()
                .longitude(LONGITUDE)
                .matricule(MATRICULE)
                .latitude(LATITUDE).build();

        Mockito.when(recupererCoordonneesGPSUserCase.recupererCoordonneesGPS(MATRICULE)).thenReturn(Arrays.asList(positionGPS));

    }


    private void positionGpsEstRetourne() throws JSONException {
        assertThat(responseStatusCode).isEqualTo(200);

        String expectedResponse = "[{\"matricule\":\"AQ-04-1478\",\"latitude\":\"147.258\",\"longitude\":\"18.258\"}]";

        JSONAssert.assertEquals(expectedResponse, responseContent, false);
    }


}
