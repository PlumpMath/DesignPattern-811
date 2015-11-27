package statePattern.candyMachine;

import statePattern.candyMachine.states.*;


/**
 * Created by Sorcerer on 2015/11/25.
 */
public class GumballMachine {

    public State soldOutState;
    public State noQuarterState;
    public State hasQuarterState;
    public State soldState;
    public State winnerState;

    private State state = soldOutState;

    private int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        count = numberGumballs;
        if (count > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot.");
        if (count != 0) {
            count -= 1;
        }
    }

    public int getCount(){
        return count;
    }
}

