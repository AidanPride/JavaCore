package lesson9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;


public class FileCopy {
    public static void main(String[] args) {
File file = new File("F:/JavaWorkSpace/JD/frame2.txt");
        try {
            copyFile(file);
            copyFileWhithBuffer(file);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void copyFile(File file) throws IOException{
        File dest = new File(file.getParent() + "/Copy" + file.getName());
        Files.copy(file.toPath() , dest.toPath());
    }
 public static void copyFileWhithBuffer(File file) throws  IOException{
     StringBuilder builder = new StringBuilder();
     InputStream inputStream = Files.newInputStream(file.toPath());
     int i = 0;
     try{
         BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream ,256);
         while ((i=bufferedInputStream.read()) !=-1){
             builder.append((char) i);
         }
     } catch (IOException e){
         e.printStackTrace();
     } finally {
         inputStream.close();
     }

     File dest = new File(file.getParent() + "/Copy2" + file.getName());
     OutputStream writer = Files.newOutputStream(dest.toPath(), StandardOpenOption.CREATE);
     try{
         writer.write(builder.toString().getBytes());
     }catch (IOException e){
         e.printStackTrace();
     } finally {
         writer.close();
     }

 }
}
