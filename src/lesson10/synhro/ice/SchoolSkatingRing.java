package lesson10.synhro.ice;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by User on 17.07.2016.
 */
public class SchoolSkatingRing implements SkatingRing {

    private Queue<Skates> skatesList = new LinkedBlockingQueue<Skates>();

    public SchoolSkatingRing() {

        for (int i=0; i<5; i++){
            skatesList.add(new Skates());
        }

    }



    public Queue<Skates> getSkates() {
        return skatesList;
    }

    public void setSkates(Queue<Skates> skates) {
        skatesList = skates;
    }

    @Override
    public Skates getSkates(Skater skater) {

        Skates skates = skatesList.poll();
        if(skates!=null) {
            System.out.println(skater.getName() + " got skates");
        }
        return skates;
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        skatesList.add(skates);
        System.out.println(skater.getName() + " return skates");
    }
}
