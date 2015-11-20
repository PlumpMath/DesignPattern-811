package decoratorPattern.coffeeStore.beverages;

import decoratorPattern.coffeeStore.beverages.Beverage;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public class Espresso extends Beverage {
    public Espresso(){
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
