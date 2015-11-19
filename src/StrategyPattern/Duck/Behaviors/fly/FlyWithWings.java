package strategyPattern.duck.behaviors.fly;

import strategyPattern.duck.behaviors.fly.FlyBehavior;

/**
 * Created by sorcerer on 2015/11/19 0019.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
