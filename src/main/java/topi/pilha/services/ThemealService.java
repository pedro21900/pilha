package topi.pilha.services;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import topi.pilha.model.Meal;

import java.util.List;

@Service
public class ThemealService {
    WebClient client = WebClient.create("https://www.themealdb.com/api/json/v1/1");

    public List<Meal> searchMealByName(String name) {

        List<Meal> meals = client.get().uri(uriBuilder -> uriBuilder.path("/search.php").queryParam("s", name).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Meal.class)
                .buffer()
                .blockFirst();
        return meals;

    }
}
