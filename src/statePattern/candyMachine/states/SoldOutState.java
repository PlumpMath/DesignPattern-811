package statePattern.candyMachine.states;

import statePattern.candyMachine.GumballMachine;

/**
 * Created by Sorcerer on 2015/11/25.
 */
public class SoldOutState implements State {

    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Don't insert quarter, it's sold out.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't insert quarter.");
    }

    @Override
    public void turnCrank() {
        System.out.println("There is no quarter.");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball.");
    }
}
