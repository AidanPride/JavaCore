package lesson10.synhro.ice;

/**
 * Created by User on 17.07.2016.
 */
public class SchoolSkatingRing implements SkatingRing {
    @Override
    public Skates getSkates(Skater skater) {
        System.out.println(skater.getName() + " got skates");
        return new Skates();
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        System.out.println(skater.getName() + " return skates");
    }
}
