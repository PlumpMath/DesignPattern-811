package statePattern.candyMachine.states;

import statePattern.candyMachine.GumballMachine;

/**
 * Created by Sorcerer on 2015/11/25.
 */
public class WinnerState implements State {

    private GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {
        System.out.println("YOU ARE WINNER! You get two gumballs.");
        gumballMachine.releaseBall();
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.soldOutState);
        } else gumballMachine.setState(gumballMachine.noQuarterState);
    }
}
