package factoryPattern.pizza.pizzas;

/**
 * Created by Sorcerer on 2015/11/24.
 */
public class ClamPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare: ClamPizza");
    }

    @Override
    public void bake() {
        System.out.println("bake: ClamPizza");
    }

    @Override
    public void cut() {
        System.out.println("cut: ClamPizza");
    }

    @Override
    public void box() {
        System.out.println("box: ClamPizza");
    }
}
