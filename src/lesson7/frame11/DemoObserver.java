package lesson7.frame11;

import java.util.Observer;

public class DemoObserver {
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber();

        Magazine mensHealth = new Magazine();
        Magazine forbs = new Magazine();

        NewsPaper dailyPlanet = new NewsPaper();
        NewsPaper time = new NewsPaper();

        Observer newNumer = new NewNumbers();
        Observer magazine = new SMagazine();
        Observer newsPaper = new SNewsPaper();

        subscriber.addObserver(newNumer);
        subscriber.addObserver(magazine);
        subscriber.addObserver(newsPaper);
        for (int i = 0; i < 10; i++) {
            subscriber.subscribing();
            System.out.println();
        }
        mensHealth.addObserver(magazine);
        forbs.addObserver(magazine);
    }
}
