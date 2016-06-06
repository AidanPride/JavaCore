package lesson7.frame11;

import java.util.Observable;

public class Magazine extends Observable {
    public Magazine() {
    }

    public void subscribing() {
        double d = Math.random();
        if (d < 0.5 || d > 10.0) {
            System.out.println("subscribe done!");
            setChanged();
            notifyObservers();
        } else {
            System.out.println("subscribe failed!");
        }
    }
}
