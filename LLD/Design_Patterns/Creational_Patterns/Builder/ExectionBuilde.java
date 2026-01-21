package Builder;

import java.util.ArrayList;
import java.util.List;

public class ExectionBuilde {
    public static void main(String[] args) {
        List<String> toppinngs = new ArrayList<>();
        toppinngs.add("garlic");
        toppinngs.add("potatto");
        System.err.println();

        BurgerMeal burger = new BurgerMeal.BurgerBuilder("whaet", "veg")
                .hasExtarCheese(false)
                .hasExtraSpice(true)
                .hasToppings(toppinngs)
                .build();
        burger.getBurger();
    }
}
