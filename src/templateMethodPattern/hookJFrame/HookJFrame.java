package templateMethodPattern.hookJFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sorcerer on 2015/11/24.
 */
public class HookJFrame extends JFrame {

    public HookJFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300, 300);
        this.setVisible(true);
    }

    /*
    通过覆盖修改父类paint(), 来影响算法
     */
    public void paint(Graphics graphics) {
        super.paint(graphics);
        String msg = "I rule!";
        graphics.drawString(msg, 100, 100);
    }

    public static void main(String[] args){
        HookJFrame hookJFrame = new HookJFrame("Design Pattern");
    }
}
