package decoratorPattern.coffeeStore.decorators;

import decoratorPattern.coffeeStore.beverages.Beverage;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Mocha";
    }
}
