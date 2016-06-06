package lesson9;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;

public class StreamDemo {
    public static void main(String[] args) {

        byte[] bytes = {-20, 8 , -128 , 0 , 13 , 127};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        printStreamData(byteArrayInputStream);
        System.out.println("_________________________");

        File file = new File("F:/JavaWorkSpace/JD/frame2.txt");
     try {
         printStreamData(Files.newInputStream(file.toPath(), StandardOpenOption.READ));
     } catch (IOException e){
         e.printStackTrace();
     }
    }

    public static void printStreamData(ByteArrayInputStream byteArrayInputStream){
        int i;
        while ((i = byteArrayInputStream.read()) != -1){
            System.out.println((byte) i);
        }
    }

    public static void printStreamData(InputStream inputStream) throws IOException{
        StringBuilder builder = new StringBuilder();
        int i;
        try {
            while ((i = inputStream.read()) != -1) {
                builder.append((char) i);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(builder);
    }
}
