package lesson7.frame6;

import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Magazine implements Subject{

    private List<Observer> observers;

    public Magazine() {
        observers = new ArrayList<Observer>();
    }
public void subscribing(){
    double d = Math.random();
    if (d < 0.5 || d > 10.0) {
        System.out.println("subscribe done!");
        notifyObservers();
    } else {
        System.out.println("subscribe failed!");
    }
}
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update();
        }

    }
}
