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
        System.out.println("Inserted a quarter.");
        gumballMachine.setState(gumballMachine.hasQuarterState);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter.");
    }

    @Override
    public void turnCrank() {
        System.out.println("There is no quarter.");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first.");
    }
}
