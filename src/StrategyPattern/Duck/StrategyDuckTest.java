package strategyPattern.duck;

import strategyPattern.duck.ducks.MallardDuck;
import strategyPattern.duck.ducks.ModelDuck;
import strategyPattern.duck.behaviors.fly.FlyWithWings;

/**
 * Created by sorcerer on 2015/11/19 0019.
 */
class StrategyDuckTest {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.preformFly();
        mallardDuck.preformQuack();

        ModelDuck modelDuck = new ModelDuck();
        modelDuck.display();
        modelDuck.preformFly();
        modelDuck.preformQuack();

        modelDuck.setFlyBehavior(new FlyWithWings());
        modelDuck.preformFly();
    }
}
