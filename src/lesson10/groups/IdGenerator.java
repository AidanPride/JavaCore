package lesson10.groups;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by User on 17.07.2016.
 */
public class IdGenerator {
    private AtomicInteger a = new AtomicInteger(1);

    public IdGenerator() {
    }

    public long getNextId(){
        return a.incrementAndGet();
    }
}
