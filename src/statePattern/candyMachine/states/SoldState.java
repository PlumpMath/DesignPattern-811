package statePattern.candyMachine.states;

import statePattern.candyMachine.GumballMachine;

/**
 * Created by Sorcerer on 2015/11/25.
 */
public class SoldState implements State {

    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Sorry, you can't turned twice.");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        System.out.println("Take your gumball, bye.");
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.noQuarterState);
        } else gumballMachine.setState(gumballMachine.soldOutState);
    }
}
