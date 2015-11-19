package strategyPattern.duck.Ducks;

import strategyPattern.duck.behaviors.fly.FlyWithWings;
import strategyPattern.duck.behaviors.quack.Squeak;

/**
 * Created by sorcerer on 2015/11/19 0019.
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("I'm a Mallard Duck");
    }
}
