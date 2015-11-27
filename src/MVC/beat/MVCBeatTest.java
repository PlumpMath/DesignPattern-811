package MVC.beat;

import MVC.beat.beatController.BeatController;
import MVC.beat.beatController.ControllerInterface;
import MVC.beat.beatModel.BeatModel;
import MVC.beat.beatModel.BeatModelInterface;

/**
 * Created by Sorcerer on 2015/11/27 0027.
 */
public class MVCBeatTest {
    public static void main(String[] args){
        BeatModelInterface beatModel = new BeatModel();
        ControllerInterface controller = new BeatController(beatModel);
    }
}
