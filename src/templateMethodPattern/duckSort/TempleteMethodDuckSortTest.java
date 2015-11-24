package templateMethodPattern.duckSort;

import javax.net.ssl.SSLContext;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Sorcerer on 2015/11/24.
 */
class TemplateMethodDuckSortTest {
    public static void main(String[] args) {
        Duck[] ducks = {
                new Duck("a", 12),
                new Duck("b", 23),
                new Duck("c", 31),
                new Duck("d", 2),
                new Duck("e", 10)
        };

        System.out.println("before\n");
        printDucks(ducks);

        Arrays.sort(ducks);

        System.out.println("\n\nafter");
        printDucks(ducks);

    }

    private static void printDucks(Duck[] ducks) {
        for (Duck duck : ducks) {
            System.out.println(duck.toString());
        }
    }
}
