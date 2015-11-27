package compositePatten.beat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 15-11-27.
 */
public class DJView implements ActionListener, BeatObserver, BPMObserver {

    private BeatModelInterface beatModel;
    private ControllerInterface controller;

    private JFrame viewFrame;
    private JPanel viewpanel;
    private BeatBar beatBar;
    private JLabel bpmOutputLabel;

    private JFrame controlFrame;
    private JPanel controlPanal;

    private JLabel bpmLabel;
    private JTextField bpmTextField;
    private JButton setBPMButton;

    private JButton increaseBPMButton;
    private JButton decreaseBPMButton;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem startMenuItem;
    private JMenuItem stopMenuItem;

    public DJView(ControllerInterface controller, BeatModelInterface beatModel) {
        this.controller = controller;
        this.beatModel = beatModel;
        beatModel.registerObserver((BeatObserver) this);
        beatModel.registerObserver((BPMObserver) this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == setBPMButton) {
            controller.setBPM(Integer.parseInt(bpmTextField.getText()));
        } else if (event.getSource() == increaseBPMButton) {
            controller.increaseBPM();
        } else if (event.getSource() == decreaseBPMButton) {
            controller.decreaseBPM();
        }
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

    public void createView(){

    }

    public void createControls() {
        viewpanel = new JPanel(new GridLayout(1,2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100,80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
        beatBar = new BeatBar();
        beatBar.setValue(0);

    }

    public void enableStopMenuItem() {
        stopMenuItem.setEnabled(true);
    }

    public void disableStopMenuItem() {
        stopMenuItem.setEnabled(false);
    }

    public void enableStartMenuItem() {
        startMenuItem.setEnabled(true);
    }

    public void disableStartMenuItem() {
        startMenuItem.setEnabled(false);
    }
}
