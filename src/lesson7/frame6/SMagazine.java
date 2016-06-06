package lesson7.frame6;


public class SMagazine implements observer.Observer {
    @Override
    public void update() {
        System.out.println(this.toString() + " notified.");
    }
}
