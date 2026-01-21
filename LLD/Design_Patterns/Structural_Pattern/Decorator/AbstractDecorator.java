
abstract class AbstractCoffeeDecorator implements Coffee {
    // accessing the Parent Coffee of all
    // should not be final we want to access from decorators , can be protected
    Coffee coffee;

    public AbstractCoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    // Either you can implement the methods of Cofee or you can implement in
    // decorator class [Sub class]
}
