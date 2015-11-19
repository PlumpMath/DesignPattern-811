package observerPattern.weatherDetecter.byCustomSujectAndObserver;

/**
 * Created by sorcerer on 2015/11/19 0019.
 */
public interface Observer {
    public void update(float temperature, float humidity, float pressure);
}
