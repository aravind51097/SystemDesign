public class MilkDecorator extends AbstractCoffeeDecorator {

    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDesc() {
        return coffee.getDesc() + " with added milk";
    }

    @Override
    public double getCost() {

        return coffee.getCost() + 3;
    }

}
