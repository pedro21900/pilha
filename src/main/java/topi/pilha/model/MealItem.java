package topi.pilha.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MealItem {
    private String idMeal;
    private String strMeal;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strMealThumb;
    private String strTags;
}
