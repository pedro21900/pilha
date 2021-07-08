package topi.pilha.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import topi.pilha.model.Meal;
import topi.pilha.model.MealItem;
import topi.pilha.services.ThemealService;

import java.util.List;
import java.util.Objects;

@RequestMapping("/api/meals")
@RestController
public class ThemealRest {
    @Autowired
    private ThemealService themealService;

    @GetMapping
    public ResponseEntity<List<MealItem>> searchMealByName(@RequestParam(required = false) String name,
                                                           @RequestParam(required = false) String id) {
        if (Objects.nonNull(name)) {
            return ResponseEntity.ok(themealService.searchMealByName(name).getMeals());
        } else if (Objects.nonNull(id)) {
            return ResponseEntity.ok(themealService.searchMealById(id).getMeals());
        }
        return ResponseEntity.ok(themealService.searchMealOrderByLetter().getMeals());
        //    return ResponseEntity.badRequest().build();
    }
}
