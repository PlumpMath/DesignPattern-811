package factoryPattern.pizza.stores;

import factoryPattern.pizza.SimplePizzaFactory;
import factoryPattern.pizza.pizzas.Pizza;

import java.security.PublicKey;

/**
 * Created by Sorcerer on 2015/11/24.
 */
public abstract class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory){
        this.factory = factory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza = factory.creatPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
