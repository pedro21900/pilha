package topi.pilha.services;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import topi.pilha.model.Meal;

@Service
public class ThemealService {
    WebClient client = WebClient.create("https://www.themealdb.com/api/json/v1/1");

    public Meal searchMealOrderByLetter() {

        Meal meals = client.get().uri(uriBuilder -> uriBuilder.path("/search.php").queryParam("f", "a").build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Meal.class)
                .block();
        return meals;

    }

    public Meal searchMealByName(String name) {

        Meal meals = client.get().uri(uriBuilder -> uriBuilder.path("/search.php").queryParam("s", name).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Meal.class)
                .block();
        return meals;

    }

    public Meal searchMealById(String id) {

        Meal meals = client.get().uri(uriBuilder -> uriBuilder.path("/lookup.php").queryParam("i", id).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Meal.class)
                .block();
        return meals;

    }
}
