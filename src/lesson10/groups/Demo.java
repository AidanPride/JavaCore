package lesson10.groups;

/**
 * Created by User on 17.07.2016.
 */
public class Demo {
    public static void main(String[] args) {
       IdGenerator id = new IdGenerator();


        for (int i=0; i<100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(id.getNextId());
                }
            }).start();
        }
    }
}
