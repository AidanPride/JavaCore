package Lesson4.Part2;

/**
 * Created by User on 14.03.2016.
 */
public class Demo {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();


        p1.setName("Andrey");
        p1.setAge(30);
        p1.setSalary(1000);


        p2.setName("Nikolay");
        p2.setAge(35);
        p2.setSalary(1000);


        p3.setName("Andrey");
        p3.setAge(30);
        p3.setSalary(1000);
        System.out.println(p1);
        System.out.println(p3);
//
//        System.out.println("---------------------");
//        System.out.println(p1.hashCode()+ "-1");
//        System.out.println(p2.hashCode()+ "-2");
//        System.out.println(p3.hashCode()+ "-3");
//
//
//        System.out.println(p1 == p2);
//        System.out.println(p1 == p3);
//        System.out.println(p3 == p2);
//        System.out.println("--------------------");
//
//        System.out.println(p1.equals(p2));
//        System.out.println(p1.equals(p3));
//        System.out.println(p3.equals(p2));

        p1.setSalary(10);
        System.out.println(p1);
        System.out.println(p3);

        System.out.println("---------------------");
        System.out.println(p1.hashCode()+ "-1");
        System.out.println(p3.hashCode()+ "-3");
        System.out.println(p1 == p3);
        System.out.println("--------------------");
        System.out.println(p1.equals(p3));


    }
}
