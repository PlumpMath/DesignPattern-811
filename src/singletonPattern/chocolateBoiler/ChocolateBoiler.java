package singletonPattern.chocolateBoiler;

/**
 * Created by Sorcerer on 2015/11/24.
 */
public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    public static ChocolateBoiler boiler;

    private ChocolateBoiler() {
        empty = false;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        // 双重检查加锁, 防止多线程重复创建
        if (boiler == null) {
            synchronized (ChocolateBoiler.class) {
                if (boiler != null) {
                    boiler = new ChocolateBoiler();
                }
            }
        }
        return boiler;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    private void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
