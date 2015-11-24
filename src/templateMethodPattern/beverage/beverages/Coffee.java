package templateMethodPattern.beverage.beverages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sorcerer on 2015/11/24.
 */
public class Coffee extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("Dropping Coffee through filter.");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk.");
    }

    public boolean customerWantsCondiments() {
        return getUserDesire();
    }

    private boolean getUserDesire() {
        System.out.println("Would you like to milk and sugar with your coffee (y/n)?");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String answer = null;

        try {
            answer = reader.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error trying to read your answer.");
        }

        if (answer == null) {
            return false;
        }
        return convertAnswer(answer);
    }

    private boolean convertAnswer(String answer) {
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }
        return false;
    }
}
