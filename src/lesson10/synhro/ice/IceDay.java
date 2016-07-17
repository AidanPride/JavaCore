package lesson10.synhro.ice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class IceDay {

    public static void main(String[] args) throws Exception {
        System.out.println("Ice day start");

        final SkatingRing skatingRing = new SchoolSkatingRing();

        final Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            final Skater skater = new Skater("Skater" + i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Skates skates = skatingRing.getSkates(skater);
                    sleep(random.nextInt(3000));
                    skatingRing.returnSkates(skates, skater);
                }
            }).start();
            sleep(random.nextInt(1000));
        }
    }

    public static void sleep(int timeOut){
        try {
            Thread.currentThread();
            Thread.sleep(timeOut);;
        } catch (Exception e) {
            //Ignore
        }
    }



}