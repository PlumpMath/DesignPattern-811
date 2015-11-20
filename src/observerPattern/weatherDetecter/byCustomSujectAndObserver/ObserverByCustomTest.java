package observerPattern.weatherDetecter.byCustomSujectAndObserver;

/**
 * Created by sorcerer on 2015/11/19 0019.
 */
public class ObserverByCustomTest {
    public static void main(String[] args) {
        WeatherData data = new WeatherData();
        CurrentConditionDisplay display = new CurrentConditionDisplay(data);

        data.setMeasurements(1, 2, 3);
        data.setMeasurements(3, 2, 1);

    }
}
