package decoratorPattern.coffeeStore.decorators;

import decoratorPattern.coffeeStore.beverages.Beverage;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
