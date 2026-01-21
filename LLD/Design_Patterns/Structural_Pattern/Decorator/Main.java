
class Main {
    public static void main(String[] args) {

        Coffee coldCoffee = new ColdCoffee();
        // adding sugar to cold coffee
        Coffee coldSugarCoffee = new SugarDecorator(coldCoffee);
        System.out.println("Cofee type " + coldSugarCoffee.getDesc() + " " + "Price " + coldSugarCoffee.getCost());

        Coffee hotCoffee = new HotCoffee();
        Coffee milkHotCoffee = new MilkDecorator(hotCoffee);
        System.out.println("Cofee type " + milkHotCoffee.getDesc() + " " + "Price " + milkHotCoffee.getCost());

    }
}