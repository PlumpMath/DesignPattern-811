package templateMethodPattern.beverage.beverages;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by Sorcerer on 2015/11/24.
 */
public abstract class CaffeineBeverage {
    /*
    定义为final, 防止算法被子类覆盖修改
     */
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /*
    非通用方法, 由子类独立实现
     */
    public abstract void brew();

    public abstract void addCondiments();

    /*
    通用方法, 无需抽象
     */
    public void boilWater() {
        System.out.println("Boiling water.");
    }

    public void pourInCup() {
        System.out.println("Pouring into cup.");
    }

    /*
    hook方法, 子类通过覆盖修改这个方法来间接影响算法
     */
    public boolean customerWantsCondiments() {
        return true;
    }

}

