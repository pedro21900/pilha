/*package topi.pilha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import topi.pilha.model.Meal;
import topi.pilha.model.MealItem;
import topi.pilha.rest.ThemealRest;
import topi.pilha.services.ThemealService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PilhaApplicationTests {
    @Autowired
    private ThemealService themealService;

    @Test
    public void cosumerApi() {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.themealdb.com/api/json/v1/1")
                .path("/search.php")
                .queryParam("s", "a")
                .build();

        Meal meals = themealService.searchMealByName("a");
        System.out.println(meals);
    }*/


}

