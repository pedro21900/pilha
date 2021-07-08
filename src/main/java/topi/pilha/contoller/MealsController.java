package topi.pilha.contoller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import topi.pilha.services.ThemealService;

import java.util.Objects;

@AllArgsConstructor
@Controller
public class MealsController {
    private final ThemealService themealService;


    @GetMapping({"/", "/index"})
    public String index(Model model, @RequestParam(required = false) String name) {
        if (Objects.nonNull(name)) {
            model.addAttribute("meals", themealService.searchMealByName(name).getMeals());
        } else {
            model.addAttribute("meals", themealService.searchMealOrderByLetter().getMeals());
        }
        return "index"; // name of the View
    }

    @GetMapping("/view")
    public String view(Model model, @RequestParam String id) {
        model.addAttribute("mealItem", themealService.searchMealById(id).getMeals().get(0)); // set 'John' value for 'name' attribute

        return "view"; // name of the View
    }
}