package lesson10.synhro.ice;

import java.util.concurrent.Callable;

public class Task implements Callable<Skates> {
private SchoolSkatingRing schoolSkatingRing;
        private Skates skates;

    public Task(Skates skates) {
        this.skates = skates;
    }

    @Override
    public Skates call() throws Exception {

        return skates;
    }
}
