package observerPattern.weatherDetecter.byCustomSujectAndObserver;

/**
 * Created by sorcerer on 2015/11/19 0019.
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
