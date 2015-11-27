package compositePatten.beat;

/**
 * Created by Administrator on 15-11-27.
 */
public interface ControllerInterface {
    public void start();

    public void stop();

    public void increaseBPM();

    public void decreaseBPM();

    public void setBPM(int BMP);
}
