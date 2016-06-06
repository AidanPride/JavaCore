package lesson7.frame6;


public class NewNumbers implements observer.Observer {
    @Override
    public void update() {
        System.out.println(this.toString() + " notified.");
    }
}
