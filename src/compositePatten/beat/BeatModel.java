package compositePatten.beat;

import javax.lang.model.type.ArrayType;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import java.util.ArrayList;

/**
 * Created by Administrator on 15-11-27.
 */
public class BeatModel implements BeatModelInterface, MetaEventListener {

    Sequencer sequencer; // 定序器
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

    public void beatEvent(){
        notifyBeatObservers();
    }

    @Override
    public void registerObserver(BeatObserver observer) {

    }

    @Override
    public void removeObserver(BeatObserver observer) {

    }

    @Override
    public void registerObserver(BPMObserver observer) {

    }

    @Override
    public void removeObserver(BPMObserver observer) {

    }

    @Override
    public void meta(MetaMessage meta) {

    }
}
