package decoratorPattern.coffeeStore.beverages;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

