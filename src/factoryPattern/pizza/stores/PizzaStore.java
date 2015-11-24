package factoryPattern.pizza.stores;

import factoryPattern.pizza.SimplePizzaFactory;
import factoryPattern.pizza.pizzas.Pizza;

import java.security.PublicKey;

/**
 * Created by Sorcerer on 2015/11/24.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
