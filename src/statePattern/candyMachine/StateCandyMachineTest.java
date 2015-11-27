package statePattern.candyMachine;

import java.util.Scanner;

/**
 * Created by Sorcerer on 2015/11/25.
 */
public class StateCandyMachineTest {
    public static void main(String[] args){
        GumballMachine gumballMachine = new GumballMachine(3);

        while (askUser()==1) {
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
        }
    }

    public static int askUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert quarter (y/n)?\n'q' to quit.");
        String s = scanner.next();
        if(s.length()==1){
            switch (s.charAt(0)){
                case 'q': System.exit(0);return -1;
                case 'y': return 1;
                case 'n': return 0;
                default: return askUser();
            }
        }else{
            return askUser();
        }
    }
}
