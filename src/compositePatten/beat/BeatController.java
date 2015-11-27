package compositePatten.beat;

/**
 * Created by Administrator on 15-11-27.
 */
public class BeatController implements ControllerInterface {

    private BeatModelInterface beatModel;
    private DJView djView;

    @Override
    public void start() {
        beatModel.on();
        djView = new DJView(this, beatModel);

    }

    @Override
    public void stop() {

    }

    @Override
    public void increaseBPM() {

    }

    @Override
    public void decreaseBPM() {

    }

    @Override
    public void setBPM() {

    }
}
