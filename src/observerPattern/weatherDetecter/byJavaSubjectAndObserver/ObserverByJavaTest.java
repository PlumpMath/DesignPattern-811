package observerPattern.weatherDetecter.byJavaSubjectAndObserver;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public class ObserverByJavaTest {
    public static void main(String[] args) {
        WeatherData data = new WeatherData();
        CurrentConditionDisplay display
                = new CurrentConditionDisplay(data);
        data.setMeasurements(1, 2, 3);
        data.setMeasurements(3, 2, 1);
    }
}
