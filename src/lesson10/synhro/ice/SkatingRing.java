package lesson10.synhro.ice;

public interface SkatingRing {
    Skates getSkates(Skater skater);
    void returnSkates(Skates skates, Skater skater);
}
