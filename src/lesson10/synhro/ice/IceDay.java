package lesson10.synhro.ice;

import java.util.Random;
import java.util.concurrent.CountDownLatch;


public class IceDay {

    public static void main(String[] args) throws Exception {
        System.out.println("Ice day start");

        final SkatingRing skatingRing = new SchoolSkatingRing();
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        final Random random = new Random();
        for (int i = 0; i < 10; i++) {
            final Skater skater = new Skater("Skater" + i);
            Thread thread =  new Thread(new Runnable() {
                @Override
                public void run() {

                        Skates skates = skatingRing.getSkates(skater);
                    try {
                        countDownLatch.await();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                        sleep(random.nextInt(2000));


                    skatingRing.returnSkates(skates, skater);
                }
            });
            thread.start();
            countDownLatch.countDown();


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