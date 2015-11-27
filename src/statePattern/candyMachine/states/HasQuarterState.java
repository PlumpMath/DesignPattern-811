package statePattern.candyMachine.states;

import statePattern.candyMachine.GumballMachine;

import java.util.Random;

/**
 * Created by Sorcerer on 2015/11/25.
 */
public class HasQuarterState implements State {

    private GumballMachine gumballMachine;

    Random randomWin = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter return.");
        gumballMachine.setState(gumballMachine.noQuarterState);
    }

    @Override
    public void turnCrank() {
        System.out.println("Turned..");
        if (randomWin.nextInt(10) == 0 && gumballMachine.getCount() >= 2) {
            gumballMachine.setState(gumballMachine.winnerState);
        } else gumballMachine.setState(gumballMachine.soldState);
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispense.");
    }
}
