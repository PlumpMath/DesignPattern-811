package decoratorPattern.coffeeStore;

import decoratorPattern.coffeeStore.beverages.Beverage;
import decoratorPattern.coffeeStore.beverages.DarkRoast;
import decoratorPattern.coffeeStore.decorators.Milk;
import decoratorPattern.coffeeStore.decorators.Soy;
import decoratorPattern.coffeeStore.decorators.Whip;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
class DecoratorCoffeeTest {
    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        beverage = new Milk(beverage);
        beverage = new Whip(beverage);
        beverage = new Soy(beverage);
        System.out.println("Description: " + beverage.getDescription() + "\n"
                + "Cost: " + beverage.cost());
    }
}
