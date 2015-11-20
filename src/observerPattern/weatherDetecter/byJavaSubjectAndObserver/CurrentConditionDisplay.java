package observerPattern.weatherDetecter.byJavaSubjectAndObserver;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Condition Display:\n"
                + temperature + "C degrees\n"
                + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
