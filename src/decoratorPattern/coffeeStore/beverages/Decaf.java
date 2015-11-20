package decoratorPattern.coffeeStore.beverages;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public class Decaf extends Beverage {
    public Decaf(){
        this.description = "Decaf";
    }

    @Override
    public double cost() {
        return 4.0;
    }
}
