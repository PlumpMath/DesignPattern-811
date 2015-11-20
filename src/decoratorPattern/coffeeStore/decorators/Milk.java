package decoratorPattern.coffeeStore.decorators;

import decoratorPattern.coffeeStore.beverages.Beverage;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public class Milk extends CondimentDecorator {
    private Beverage beverage;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2.0;
    }
}
