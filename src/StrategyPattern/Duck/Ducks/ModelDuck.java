package strategyPattern.duck.Ducks;

import strategyPattern.duck.behaviors.fly.FlyNoWay;
import strategyPattern.duck.behaviors.quack.MuteQuack;

/**
 * Created by sorcerer on 2015/11/19 0019.
 */
public class ModelDuck extends Duck {
    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm a Model Duck.");
    }
}
