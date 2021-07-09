package topi.pilha;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import topi.pilha.model.MealItem;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

//Inicializamos o SpringRunner
@RunWith(SpringRunner.class)
@SpringBootTest

public class PilhaApplicationTests {
    //URL base para onde as requests serão feitas
    final String BASE_PATH = "http://pilha-1625805102532.azurewebsites.net";

    //Definimos o restTemplate
    private RestTemplate restTemplate;

    private ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void testCreatePerson() throws IOException {
        restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity(headers);

        //Fazemos uma requisição HTTP GET buscando as meals
        ResponseEntity<String> response = restTemplate
                .exchange(BASE_PATH + "/api/meals?s=a", HttpMethod.GET, entity, String.class);

        //Convertemos a resposta JSON para Objeto usando op Jackson

        List<MealItem> meals = MAPPER
                .readValue(response.getBody(), MAPPER.getTypeFactory()
                        .constructCollectionType(List.class, MealItem.class));

        //Verificamos se o resultado da requisição é igual ao esperado
        //Se sim significa que tudo correu bem
        Assert.assertNotNull(meals.get(0));
        Assert.assertEquals("Tart,Baking,Fruity", meals.get(0).getStrTags());
    }


}