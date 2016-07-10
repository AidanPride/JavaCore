package lesson10.balls;

import java.awt.*;
import java.util.Random;

/**
 * Created by User on 10.07.2016.
 */
public class Ball implements Runnable{
    private int x;
    private int y;
    private Color color;
    private int speed;

    public Ball(int y) {
        speed = initSpeed();
        x=10;
        this.y = y;
        color = initColor();

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private Color initColor(){
        Random r = new Random();
        int i =r.nextInt(255);
        int b = r.nextInt(255);
        int a = r.nextInt(255);
        return new Color(i, b, a);
    }
    private int initSpeed(){
        int speed;
        Random r = new Random();
        speed = r.nextInt(40);
        return speed;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
       g.fillOval(x, y, 20 , 20);

    }


    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 480; i++) {
                x ++;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (x < 500) {
                    continue;
                }
                break;
            }
            for (int i = 0; i < 500; i++) {
                x --;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

