package statePattern.candyMachine.states;

import statePattern.candyMachine.GumballMachine;

/**
 * Created by Sorcerer on 2015/11/25.
 */
public class NoQuarterState implements State{

    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine){
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

    }
}