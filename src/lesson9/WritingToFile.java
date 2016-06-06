package lesson9;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class WritingToFile {
    public static void main(String[] args) {
        File file = new File("test.txt");

        String text = "Hellow World! :) ";
        try (
                FileOutputStream fos = new FileOutputStream(file.getName());
                PrintStream printStream = new PrintStream(fos)
        ) {
            printStream.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


