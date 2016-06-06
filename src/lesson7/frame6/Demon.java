package lesson7.frame6;

import observer.*;
import observer.Observer;

public class Demon {
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber();

        Magazine mensHealth = new Magazine();
        Magazine forbs = new Magazine();

        NewsPapaer dailyPlanet = new NewsPapaer();
        NewsPapaer time = new NewsPapaer();

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
