package lesson6.game;

import javax.swing.*;
import java.awt.*;

public class Joke{
Circle circle;
    public Joke() {
        circle = new Circle();
        JFrame f = new JFrame("Click circle");
        f.setLocation(100,100);
        f.setMinimumSize(new Dimension(600,600));
//        f.addMouseMotionListener();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

}
