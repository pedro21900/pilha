package topi.pilha.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Meal {
    private List<MealItem> meals = new ArrayList<>();

}
