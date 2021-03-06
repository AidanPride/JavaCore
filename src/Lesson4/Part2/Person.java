package Lesson4.Part2;

public class Person {
    private String name;
    private int age;
    private long salary;


    public Person() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = 37 * result + ((Integer) age).hashCode();
        result = 37 * result + ((Long) salary).hashCode();
        result = 37 * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return (name != null && name.equals(p.getName()) && age == p.getAge() && salary == p.getSalary());
        }
        return false;
    }
}