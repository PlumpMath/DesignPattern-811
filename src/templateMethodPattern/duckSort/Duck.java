package templateMethodPattern.duckSort;

/**
 * Created by Sorcerer on 2015/11/24.
 */
public class Duck implements Comparable {
    private String name;
    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return "name: " + name + " weight: " + weight;
    }


    /*
    实现compareTo以实现算法
     */
    @Override
    public int compareTo(Object o) {

        Duck otherDuck = (Duck) o;

        if (weight < otherDuck.getWeight()) {
            return -1;
        } else if (weight == otherDuck.getWeight()) {
            return 0;
        } else return 1;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
