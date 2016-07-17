package lesson10.synhro.ice;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class DemoWithExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        final SkatingRing skatingRing = new SchoolSkatingRing();
        final Random random = new Random();

        List<Future<Skates>> futureList = new ArrayList<>();

        try{
         for(int i=0; i<10;i++){
            final Skater skater = new Skater("Skater"+i);
            futureList.add(executorService.submit(new Task(skatingRing.getSkates(skater))));
            skatingRing.returnSkates(futureList.get(i).get() , skater);
            sleep(random.nextInt(1000));
         }
        }finally {
           executorService.shutdown();
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

