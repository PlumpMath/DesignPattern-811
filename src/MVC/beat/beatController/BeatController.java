package MVC.beat.beatController;

import MVC.beat.DJView;
import MVC.beat.beatModel.BeatModelInterface;

/**
 * Created by Administrator on 15-11-27.
 */
public class BeatController implements ControllerInterface {

    private BeatModelInterface beatModel;
    private DJView djView;

    public BeatController(BeatModelInterface beatModel) {
        this.beatModel = beatModel;
        djView = new DJView(this, beatModel);
        djView.createView();
        djView.createControls();
        djView.disableStopMenuItem();
        djView.enableStartMenuItem();
        this.beatModel.initialize();
    }

    @Override
    public void start() {
        beatModel.on();
        djView = new DJView(this, beatModel);
        djView.disableStartMenuItem();
        djView.enableStopMenuItem();
    }

    @Override
    public void stop() {
        beatModel.off();
        djView.enableStartMenuItem();
        djView.disableStopMenuItem();
    }

    @Override
    public void increaseBPM() {
        beatModel.setBPM(beatModel.getBPM() + 1);
    }

    @Override
    public void decreaseBPM() {
        beatModel.setBPM(beatModel.getBPM() - 1);
    }

    @Override
    public void setBPM(int BMP) {
        beatModel.setBPM(BMP);
    }

}
