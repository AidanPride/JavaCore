package lesson10.synhro.ice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by User on 17.07.2016.
 */
public class SchoolSkatingRing implements SkatingRing {
    private Lock skateLock;
    private List<Skates> skatesList;

    public SchoolSkatingRing() {
        skatesList = new ArrayList<>();
        for (int i=0; i<5; i++){
            skatesList.add(new Skates());
        }
        skateLock = new ReentrantLock();
    }

    public Lock getSkateLock() {
        return skateLock;
    }

    public void setSkateLock(Lock skateLock) {
        this.skateLock = skateLock;
    }

    public List<Skates> getSkates() {
        return skatesList;
    }

    public void setSkates(List<Skates> skates) {
        skatesList = skates;
    }

    @Override
    public Skates getSkates(Skater skater) {
        if(skatesList.isEmpty()){
            try{
                synchronized (skatesList){
                    skatesList.wait();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        skateLock.lock();
        Skates skates = skatesList.remove(0);
        skateLock.unlock();

        System.out.println(skater.getName() + " got skates");
        return new Skates();
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        skatesList.add(skates);
        synchronized (skatesList){
            skatesList.notify();
        }

        System.out.println(skater.getName() + " return skates");
    }
}
