package simple;

import java.util.Arrays;

/**
 * Created by User on 28.06.2016.
 */
public class Demo {
    public static void main(String[] args) {

        SimpleLinkedList simpleLinkedListt = new SimpleLinkedList();
        simpleLinkedListt.add("abdedxfxdfg");
        simpleLinkedListt.add(true);

        System.out.println(Arrays.toString(simpleLinkedListt.readFromFile()));

        simpleLinkedListt.remove("abdedxfxdfg");
        System.out.println(simpleLinkedListt.size());

        simpleLinkedListt.add(13);
        simpleLinkedListt.add(666);
    }
}
