package lesson5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;


public class Window extends JPanel {
private Image img;
    public Window() {
        try {
            img = ImageIO.read(new File("dogs.jpg"));
        } catch (IOException e) {
            System.err.println("Cannot find image");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img, 200, 50, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        JPanel p = new JPanel();
        JFrame frame = new JFrame("My first window");
        frame.setLocation(300, 200);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Window());
        frame.pack();
        frame.setVisible(true);

    }
}
