package observerPattern.weatherDetecter.byCustomSujectAndObserver;

/**
 * Created by sorcerer on 2015/11/19 0019.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private Subject weatherData;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Condition Display:\n"
                + temperature + "C degrees\n"
                + humidity + "% humidity\n"
                + pressure + "pa pressure");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
