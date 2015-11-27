package compositePatten.beat;

/**
 * Created by Administrator on 15-11-27.
 */
public interface BeatModelInterface {
    void initialize();

    void on();

    void off();

    void setBPM(int BPM);

    int getBPM();

    void registerObserver(BeatObserver observer);

    void removeObserver(BeatObserver observer);

    void registerObserver(BPMObserver observer);

    void removeObserver(BPMObserver observer);
}
