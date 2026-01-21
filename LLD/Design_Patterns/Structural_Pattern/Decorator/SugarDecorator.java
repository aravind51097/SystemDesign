public class SugarDecorator extends AbstractCoffeeDecorator {
    SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDesc() {
        return coffee.getDesc() + " with added Sugar";
    }

    @Override
    public double getCost() {

        return coffee.getCost() + 3;
    }
}
