package decoratorPattern.coffeeStore.decorators;

import decoratorPattern.coffeeStore.beverages.Beverage;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public class Whip extends CondimentDecorator {
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.5;
    }
}
