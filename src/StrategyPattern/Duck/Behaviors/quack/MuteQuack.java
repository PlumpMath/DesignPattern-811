package strategyPattern.duck.behaviors.quack;

/**
 * Created by sorcerer on 2015/11/19 0019.
 */
public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
