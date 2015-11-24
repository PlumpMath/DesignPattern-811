package strategyPattern.duck.ducks;

import strategyPattern.duck.behaviors.fly.FlyBehavior;
import strategyPattern.duck.behaviors.quack.QuackBehavior;

/**
 * Created by sorcerer on 2015/11/19 0019.
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void setFlyBehavior(FlyBehavior behavior) {
        flyBehavior = behavior;
    }

    public void setQuackBehavior(QuackBehavior behavior) {
        quackBehavior = behavior;
    }

    public abstract void display();

    public void preformFly() {
        flyBehavior.fly();
    }

    public void preformQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
}
