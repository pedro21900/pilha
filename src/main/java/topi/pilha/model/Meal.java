package topi.pilha.model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
//Foi usado lombok para automatizar a classe
@Getter // Ativa métodos getters usando lombok
@ToString //
public class Meal {
    private List<MealItem> meals = new ArrayList<>();

}
