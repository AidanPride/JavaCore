package lesson5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class DrawingPanel extends JPanel{
private Image img;
    private String IMG_NAME= "dogs.jpg";
    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public DrawingPanel() {
        try{
            img = ImageIO.read(new File(IMG_NAME));
        }catch (IOException e){
            System.out.println("There is no file");
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.blue);
        g.fillRect(0,0,800,600);
        g.setColor(Color.red);
        g.fillOval(300, 200 , 100, 50);
        g.setColor(Color.black);
        g.drawString("Hi, Master", 320,230);
        g.drawImage(img, 300, 300, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });



    }

    public static void main(String[] args) {
        JPanel p = new JPanel();
        JFrame f = new JFrame("Helloy World");
        f.setLocation(300,100);
        f.setMinimumSize(new Dimension(800,600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(p);
        f.getContentPane().add(new DrawingPanel());
        f.pack();
        f.setVisible(true);


    }
}
