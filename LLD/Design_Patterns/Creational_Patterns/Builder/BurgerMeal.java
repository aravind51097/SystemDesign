package Builder;

import java.util.List;

public class BurgerMeal {
    // mandatort fields
    private final String bunType;
    private final String patty;

    // Optional items
    private boolean extaCheese;
    private List<String> toppings;
    private boolean extraSpicey;

    BurgerMeal(BurgerBuilder builder) {
        this.bunType = builder.bunType;
        this.patty = builder.patty;
        this.extaCheese = builder.extaCheese;
        this.toppings = builder.toppings;
        this.extraSpicey = builder.extraSpicey;
    }

    public void getBurger() {
        System.out.println("Burger made with bunType: " + bunType +
                ", patty: " + patty +
                ", extraCheese: " + extaCheese +
                ", toppings: " + (toppings != null ? toppings : "none") +
                ", extraSpicy: " + extraSpicey);
    }

    public static class BurgerBuilder {
        private final String bunType;
        private final String patty;

        // Optional items
        private boolean extaCheese;
        private List<String> toppings;
        private boolean extraSpicey;

        public BurgerBuilder(String bunType, String patty) {
            this.bunType = bunType;
            this.patty = patty;
        }

        public BurgerBuilder hasExtarCheese(boolean hasExtarCheese) {
            this.extaCheese = hasExtarCheese;
            return this;
        }

        public BurgerBuilder hasToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        public BurgerBuilder hasExtraSpice(boolean spice) {
            this.extraSpicey = spice;
            return this;
        }

        public BurgerMeal build() {
            return new BurgerMeal(this);
        }

    }

}
