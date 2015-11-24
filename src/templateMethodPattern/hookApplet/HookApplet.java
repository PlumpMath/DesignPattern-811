package templateMethodPattern.hookApplet;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by Sorcerer on 2015/11/24.
 */
public class HookApplet extends Applet {
    String message;

    public void init() {
        message = "Hello World!";
        repaint();
    }

    public void start() {
        message = "I'm starting up...";
        repaint();
    }

    public void stop() {
        message = "I'm being stopped...";
        repaint();
    }

    public void destroy() {
        message = "I'm being destoryed...";
        repaint();
    }

    public void paint(Graphics graphics) {
        graphics.drawString(message, 5, 15);
    }

    public static void main(String[] args){
        HookApplet hookApplet = new HookApplet();
    }
}
