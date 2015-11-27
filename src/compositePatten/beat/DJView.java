package compositePatten.beat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 15-11-27.
 */
public class DJView implements ActionListener, BeatObserver, BPMObserver {

    private BeatModelInterface beatModel;
    private ControllerInterface controller;

    private JFrame viewJFrame;
    private JPanel viewJpanel;
    private BeatBar beatBar;
    private JLabel bpmOutputLabel;

    public DJView(ControllerInterface controller, BeatModelInterface beatModel) {
        this.controller = controller;
        this.beatModel = beatModel;
        beatModel.registerObserver((BeatObserver) this);
        beatModel.registerObserver((BPMObserver) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void updateBPM() {
        int BPM = beatModel.getBPM();
        if (BPM == 0) {
            bpmOutputLabel.setText("offline");
        } else {
            bpmOutputLabel.setText("Current BPM: " + beatModel.getBPM());
        }
    }

    @Override
    public void updateBeat() {
        beatBar.setValue(100);
    }
}
