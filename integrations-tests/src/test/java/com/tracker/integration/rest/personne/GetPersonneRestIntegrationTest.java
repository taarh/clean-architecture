package com.tracker.integration.rest.personne;

import com.tracker.entity.Personne;
import com.tracker.entrypoints.rest.personne.CreerPersonneEndpoint;
import com.tracker.entrypoints.rest.personne.RecupererPersonneEndpoint;
import com.tracker.integration.rest.RestIntegrationTest;
import com.tracker.usercase.personne.RecupererPersonneUserCase;
import com.tracker.usercase.personne.exception.PersonneNonTrouveException;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ContextConfiguration(classes = {RestIntegrationTest.class})
@WebMvcTest(RecupererPersonneEndpoint.class)
public class GetPersonneRestIntegrationTest extends RestIntegrationTest {
    public static final String API_PATH = "/getPersonne";
    private static final String EMAIL = "arhalai@gmail.com";

    private static final Logger LOGGER = LoggerFactory.getLogger(CreerPersonneEndpoint.class);
    @MockBean
    private RecupererPersonneUserCase recupererPersonneUserCase;
    @Autowired
    MockMvc mockMvc;
    String responseContent;
    int responseStatusCode;

    @Test
    public void personneEstRecupere() throws Exception {
        etantDonneUnePersonne();

        quandRecupererPersonneApiEstAppele();

        personneEstRetourne();
    }

    @Test
    public void retourner404QuandPersonneNonTrouve() throws Exception {
        etantDonneeUnePersonneNoTrouve();

        quandRecupererPersonneApiEstAppele();

        alorsReturner404();
    }

    public void quandRecupererPersonneApiEstAppele() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(RecupererPersonneEndpoint.API_PATH + "/{email}", EMAIL)).andReturn();
        responseContent = mvcResult.getResponse().getContentAsString();
        responseStatusCode = mvcResult.getResponse().getStatus();
    }

    public void etantDonneUnePersonne() {
        Personne personne = Personne
                .builder()
                .age(10)
                .email(EMAIL)
                .prenom("taoufik")
                .nom("arhalai")
                .build();

        Mockito.when(recupererPersonneUserCase.recupererPersonneParEmail(EMAIL)).thenReturn(personne);

    }


    private void personneEstRetourne() throws JSONException {
        assertThat(responseStatusCode).isEqualTo(200);

        String expectedResponse = "{\"nom\":\"arhalai\",\"prenom\":\"taoufik\",\"age\":10,\"email\":\"arhalai@gmail.com\"}";

        JSONAssert.assertEquals(expectedResponse, responseContent, false);
    }

    private void etantDonneeUnePersonneNoTrouve() {
        when(recupererPersonneUserCase.recupererPersonneParEmail(EMAIL)).thenThrow(new PersonneNonTrouveException());
    }

    private void alorsReturner404() {
        assertThat(responseStatusCode).isEqualTo(404);
    }

}
