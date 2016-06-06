package lesson8.generics.frame3;

public class Box<T> {
    private T item;

    public Box() {
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void removeItem(){
        item=null;
    }

   public static void main(String [] args){
       Box<Integer> box1= new Box<>();
       box1.setItem(13);
       System.out.println(box1.getItem());
       box1.removeItem();
       System.out.println(box1.getItem());

       System.out.println("___________________________");

       Box<String> box2 = new Box<>();
       box2.setItem("Test");
       System.out.println(box2.getItem());
       box2.removeItem();
       System.out.println(box2.getItem());
   }
}
