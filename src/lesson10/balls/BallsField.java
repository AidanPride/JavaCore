package lesson10.balls;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by User on 10.07.2016.
 */
public class BallsField extends JPanel {

    private ArrayList<Ball> balls;

    public BallsField() {
        int coord = 0;
         balls = new ArrayList<>();
        for (int n = 0; n<10; n++){
            balls.add(new Ball(coord));
            coord = coord+30;
        }

        JFrame frame = new JFrame("Flying balls");
        frame.setMinimumSize(new Dimension(500 , 400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Ball ball:balls){
            ball.draw(g);
        }

    }
    public void runBalls() {
        for (Ball b : balls) {
            new Thread(b).start();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
