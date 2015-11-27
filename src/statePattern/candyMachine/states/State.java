package statePattern.candyMachine.states;

/**
 * Created by Sorcerer on 2015/11/25.
 */
public interface State {
    public void insertQuarter(); // 投币
    public void ejectQuarter(); // 退币
    public void turnCrank(); // 转动手柄
    public void dispense(); // 发放糖果
}
