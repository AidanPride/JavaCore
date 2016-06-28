package simple;

import java.io.*;
import java.util.Iterator;


public class SimpleLinkedList  implements SimpleList<Object>, Serializable, Iterable{
    private File file;

    public SimpleLinkedList(){

        file = new File("simplelist.txt");
    }

    @Override
    public void add(Object object) {

        writeToFile(object);
    }

    @Override
    public boolean contains(Object object) {

        String[] arrFromFile = readFromFile();
        for (String str : arrFromFile) {
            if (str.equalsIgnoreCase(object.toString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(Object object) {

        removeFromFile(object);
    }

    @Override
    public int size() {

        String[] arrFromFile = readFromFile();
        int size = 0;
        for (String str : arrFromFile) {
            if (!str.equals("")) {
                size++;
            }
        }
        return size;
    }

    @Override
    public Iterator iterator() {

        return new SimpleListIterator();
    }

    public void writeToFile(Object object) {

        try(FileOutputStream outputStream = new FileOutputStream(file, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);

        ) {
            String[] arrFromFile = readFromFile();
            boolean hasEmpty = false;
            for (int i = 0; i < arrFromFile.length; i++) {
                if (arrFromFile[i].equals("")) {
                    arrFromFile[i] = object.toString();
                    hasEmpty = true;
                    break;
                }
            }
            if (!hasEmpty) {
                writer.write(object.toString() + "\n");
            }
            else {
                outputStream.getChannel().truncate(0);

                for (int i = 0; i < arrFromFile.length; i++) {
                    writer.write(arrFromFile[i]  + "\n");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] readFromFile() {

        StringBuilder builder = new StringBuilder();

        try(InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String str;
            while ((str = reader.readLine()) != null) {
                builder = builder.append(str);
                builder = builder.append("\n\r");
            }
            System.out.println(builder);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString().split("\n\r");
    }

    public void removeFromFile(Object object) {

        try(FileOutputStream outputStream = new FileOutputStream(file, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        ) {
            String[] arrFromFile = readFromFile();

            int objPosition = getObjectPosition(object, arrFromFile);
            System.out.println(objPosition);
            if (objPosition > -1) {
                arrFromFile[objPosition] = "";
                outputStream.getChannel().truncate(0);

                for (int i = 0; i < arrFromFile.length; i++) {
                    writer.write(arrFromFile[i]  + "\n");
                }
            }
            else {
                System.out.println("There isn't such object");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getObjectPosition(Object object, String[] arr) {

        String[] arrFromFile = arr;
        for (int i = 0; i < arrFromFile.length; i++) {

            if (arrFromFile[i].equalsIgnoreCase(object.toString())) {
                return i;
            }
        }
        return -1;
    }

    private class SimpleListIterator implements Iterator {

        String[] arrFromFile = readFromFile();
        private int curr;

        public SimpleListIterator() {
            curr = 0;
        }

        @Override
        public boolean hasNext() {

            if (arrFromFile[curr + 1] != null) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (curr == 0 && arrFromFile[0] != null) {
                return arrFromFile[0];
            }
            else if (hasNext()) {
                curr++;
                return arrFromFile[curr];
            }
            return null;
        }

        @Override
        public void remove() {
        }
    }
}
