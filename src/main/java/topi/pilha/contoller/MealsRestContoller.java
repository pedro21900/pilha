/*
package topi.pilha.contoller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import topi.pilha.model.Meal;
import topi.pilha.model.MealItem;

@RestController
@RequestMapping("index")
public class MealsRestContoller {

    @GetMapping
    public List<MealItem> mealItems(@RequestParam(value = "q", required = false) String query) {
        if (StringUtils.isEmpty(query)) {
            return Arrays.stream()
                    .limit(15)
                    .map(this::mapTomealItem)
                    .collect(Collectors.toList());
        }

        return Arrays.stream(Meal.values())
                .filter(meal -> meal.getLabel()
                        .toLowerCase()
                        .contains(query))
                .limit(15)
                .map(this::mapTomealItem)
                .collect(Collectors.toList());
    }

    private MealItem mapTomealItem(Meal meal) {
        return MealItem.builder()
                .id(state)
                .text(state.getLabel())
                .slug(state.name())
                .build();
    }
}

*/
