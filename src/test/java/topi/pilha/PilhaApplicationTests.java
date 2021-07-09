package topi.pilha;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.erudio.models.Person;
import br.com.erudio.repository.PersonRepository;
import topi.pilha.model.Meal;
import topi.pilha.model.MealItem;
import topi.pilha.services.ThemealService;

//Inicializamos o SpringRunner
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PilhaApplicationTests {
    //URL base para onde as requests serão feitas
    final String BASE_PATH = "http://localhost:8080";
@Autowired
    private ThemealService themealService;

    //Definimos o restTemplate
    private RestTemplate restTemplate;

    //Definimos o JacksonMapper responsável por converter
    //JSON para Objeto e vice versa
    private ObjectMapper MAPPER = new ObjectMapper();

    public void testFindOne() throws IOException{

        //Fazemos uma requisição HTTP GET buscando por todas as pessoas
        String response = restTemplate
                .getForObject(BASE_PATH + "/", String.class);

        //Pegamos o ID da pessoa na posição 1 da lista e fazemos nova requisição
        //Recuperando as informações da mesma
        Meal meal = themealService.searchMealById("52768");

        //Verificamos se o resultado da requisição é igual ao esperado
        //Se sim significa que tudo correu bem
        Assert.assertNotNull(meal);
        Assert.assertEquals("Apple Frangipan Tart", meal.getMeals().get(0).getStrMeal());
        Assert.assertEquals("Silva", meal);
    }


}