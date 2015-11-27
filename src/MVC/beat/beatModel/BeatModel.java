package MVC.beat.beatModel;

import MVC.beat.observerInterface.BPMObserver;
import MVC.beat.observerInterface.BeatObserver;

import javax.sound.midi.*;
import java.util.ArrayList;

/**
 * Created by Administrator on 15-11-27.
 */
public class BeatModel implements BeatModelInterface, MetaEventListener {

    Sequencer sequencer; // 定序器
    Sequence sequence;
    Track track;
    ArrayList<BeatObserver> beatObservers = new ArrayList<>();
    ArrayList<BPMObserver> bpmObservers = new ArrayList<>();
    int BPM;

    @Override
    public void initialize() {
        setUpMidi();
        buildTrackAndStart();
    }

    @Override
    public void on() {
        sequencer.start();
        setBPM(90);
    }

    @Override
    public void off() {
        setBPM(0);
        sequencer.stop();
    }

    @Override
    public void setBPM(int BPM) {
        this.BPM = BPM;
        sequencer.setTempoInBPM(getBPM()); // 定序器改变BPM
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return BPM;
    }

    public void beatEvent() {
        notifyBeatObservers();
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        beatObservers.add(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        beatObservers.remove(observer);
    }

    public void notifyBeatObservers() {
        beatObservers.forEach(BeatObserver::updateBeat);
    }

    @Override
    public void registerObserver(BPMObserver observer) {
        bpmObservers.add(observer);
    }

    @Override
    public void removeObserver(BPMObserver observer) {
        bpmObservers.add(observer);
    }

    public void notifyBPMObservers() {
        bpmObservers.forEach(BPMObserver::updateBPM);
    }

    @Override
    public void meta(MetaMessage meta) {
        if (meta.getType() == 47) {
            beatEvent();
            sequencer.start();
            setBPM(getBPM());
        }
    }

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart() {
        int[] trackList = {35, 0, 46, 0};

        sequence.deleteTrack(null);
        track = sequence.createTrack();

        makeTracks(trackList);
        track.add(makeEvent(192, 9, 1, 0, 4));
        try {
            sequencer.setSequence(sequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeTracks(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}
