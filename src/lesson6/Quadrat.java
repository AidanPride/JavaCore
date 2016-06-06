package lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by User on 28.03.2016.
 */
public class Quadrat{
    public Quadrat() {
        JFrame f = new JFrame();
        f.setLocation(100,100);
        f.setMinimumSize(new Dimension(300,300));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(makePanel());
        f.pack();
        f.setVisible(true);
    }

    private JPanel makePanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));
        JButton button = new JButton();
        button.setBackground(new Color(100,100,0));
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                int i =r.nextInt(255);
                int b = r.nextInt(255);
                int a = r.nextInt(255);
                button.setBackground(new Color(i,a,b));
            }
        });
        return panel;
    }

    public static void main(String[] args) {
        Quadrat quad = new Quadrat();
    }

}
