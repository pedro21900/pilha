package topi.pilha.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import topi.pilha.model.Meal;
import topi.pilha.services.ThemealService;

import java.util.List;

@RequestMapping("/api/meals")
@RestController
public class ThemealRest {
    @Autowired
    private ThemealService themealService;

    @GetMapping
    public List<Meal> searchMealByName(@RequestParam String name) {
        return themealService.searchMealByName(name);
    }
}
