package MVC.beat;

import MVC.beat.observerInterface.BPMObserver;
import MVC.beat.beatController.ControllerInterface;
import MVC.beat.beatModel.BeatModelInterface;
import MVC.beat.observerInterface.BeatObserver;

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
    private JPanel viewPanel;
    private BeatBar beatBar;
    private JLabel bpmOutputLabel;

    private JFrame controlFrame;
    private JPanel controlPanel;

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

    public void createView() {
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
        beatBar = new BeatBar();
        beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    public void createControls() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));

        controlPanel = new JPanel(new GridLayout(1, 2));

        menuBar = new JMenuBar();
        menu = new JMenu("DJ control");
        startMenuItem = new JMenuItem("start");
        startMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.start();
            }
        });
        menu.add(startMenuItem);
        stopMenuItem = new JMenuItem("stop");
        startMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.stop();
            }
        });
        menu.add(stopMenuItem);
        JMenuItem exit = new JMenuItem("exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exit);
        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);

        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM: ", SwingConstants.RIGHT);
        setBPMButton = new JButton("Set");
        setBPMButton.setSize(new Dimension(10, 40));
        increaseBPMButton = new JButton(">>");
        decreaseBPMButton = new JButton("<<");
        setBPMButton.addActionListener(this);
        increaseBPMButton.addActionListener(this);
        decreaseBPMButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

        buttonPanel.add(decreaseBPMButton);
        buttonPanel.add(increaseBPMButton);

        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);
        JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(buttonPanel);
        controlPanel.add(insideControlPanel);

        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
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
