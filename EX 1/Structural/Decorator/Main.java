public class Main {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();

        System.out.println(simpleCoffee.getDescription() + " $" + simpleCoffee.getCost());

        // Add Milk
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println(milkCoffee.getDescription() + " $" + milkCoffee.getCost());

        // Add Sugar and Milk
        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println(sugarMilkCoffee.getDescription() + " $" + sugarMilkCoffee.getCost());

        // Add Chocolate, Milk, and Sugar dynamically
        Coffee fancyCoffee = new ChocolateDecorator(new MilkDecorator(new SugarDecorator(new SimpleCoffee())));
        System.out.println(fancyCoffee.getDescription() + " $" + fancyCoffee.getCost());
    }
}
