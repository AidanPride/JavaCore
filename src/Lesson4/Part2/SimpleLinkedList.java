package Lesson4.Part2;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Object>{
    private Node root;
    private int size;
    private Node prev;

    public SimpleLinkedList() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addFirst(Object obj){
          Node node = new Node();
          node.setObj(obj);

           if (root!=null) {
               node.ref = root;
           }
            root=node;
          size++;
    }

    public void addLast(Object obj){
        Node node = new Node();
        node.setObj(obj);

        if (root ==null){
            root = node;
        }else{
            Node last = root;
            Node currentPosition = root;
            while (currentPosition.ref!=null){
                last=currentPosition;
                currentPosition=currentPosition.ref;
            }
            last.ref=node;
        }
        size++;



    }
    public void addAfter(Object prevObj, Object obj){
        Node prevPointer = null;
        Node currentPointer = root;
        do{
            if(currentPointer.obj==prevObj){
                prevPointer=currentPointer;
                break;
            }
            currentPointer = currentPointer.ref;
        }while(currentPointer!=null && currentPointer.ref!=null);

        if (prevPointer==null){
            throw new IllegalStateException("List does not contain prec Object");
        }

        Node node = new Node();
        node.setObj(obj);

        if (prevPointer!=null){
            node.ref=prevPointer.ref;
        }
        prevPointer.ref=node;
        size++;

    }

    @Override
    public Iterator<Object> iterator() {
        return new SLLIterator();
    }

    private class Node {
        private Object obj;
        private Node ref;

        public Node() {
        }

        public Node getNode() {
            return ref;
        }

        public void setNode(Node node) {
            this.ref = node;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }
    }

    private class SLLIterator implements Iterator{
           private Node currentPointer;
           private Node prev;

        public SLLIterator() {
        }

        @Override
        public boolean hasNext() {
            return (currentPointer!=null && root!=null)|| (currentPointer!=null && currentPointer.ref!=null);
        }

        @Override
        public Object next() {
            if (currentPointer == null && root != null){
                currentPointer = root;
                return currentPointer.obj;
            }
            if (hasNext()){
                prev=currentPointer;
                currentPointer=currentPointer.ref;
                return currentPointer.obj;
            }
            throw new IllegalStateException("List has no elements");
        }


        @Override
        public void remove() {
            //only 1 element
            if (!hasNext() && prev == null){
                currentPointer =null;
                root = null;
            }
            // last element
            else if (!hasNext() && prev !=null){
                prev.ref=null;
            }
            // first element
            else if (hasNext() && prev ==null){
                root=currentPointer.ref;
                currentPointer=root;
            }
            //middle element
            else {
               prev.ref = currentPointer.ref;
                currentPointer = currentPointer.ref;
            }
            size--;
        }
    }
}
