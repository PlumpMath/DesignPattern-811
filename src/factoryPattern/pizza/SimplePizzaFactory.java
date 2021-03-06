package factoryPattern.pizza;

import factoryPattern.pizza.pizzas.*;

/**
 * Created by Sorcerer on 2015/11/24.
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        switch (type) {
            case "Cheese":
                pizza = new CheesePizza();
                break;
            case "Veggie":
                pizza = new VeggiePizza();
                break;
            case "Clam":
                pizza = new ClamPizza();
                break;
            case "Pepperoni":
                pizza = new PepperoniPizza();
                break;
        }
        return pizza;
    }
}
