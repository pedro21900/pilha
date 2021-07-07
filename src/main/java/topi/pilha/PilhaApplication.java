package topi.pilha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import topi.pilha.model.Meal;
import topi.pilha.services.ThemealService;

import java.util.List;

@SpringBootApplication
public class PilhaApplication implements CommandLineRunner {
    @Autowired
    private ThemealService themealService;

    public static void main(String[] args) {
        SpringApplication.run(PilhaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Meal> meals = themealService.searchMealByName("a");
        System.out.println(meals);

    }
}
