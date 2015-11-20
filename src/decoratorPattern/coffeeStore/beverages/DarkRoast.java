package decoratorPattern.coffeeStore.beverages;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        this.description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 2.3;
    }
}
