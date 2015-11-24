package templateMethodPattern.beverage;

import templateMethodPattern.beverage.beverages.Coffee;
import templateMethodPattern.beverage.beverages.Tea;

/**
 * Created by Sorcerer on 2015/11/24.
 */
class TemplateMethodBeverageTest {
    public static void main(String[] args){
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();

        Tea tea = new Tea();
        tea.prepareRecipe();
    }
}
