package lesson9;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ChangeCode {
    public static void main(String[] args) {
        File file = new File("change.txt");

        changeCoding(file, "UTF-8" , "UTF-16BE");
    }

    public static void changeCoding(File file, String current , String needed){
         StringBuilder builder = new StringBuilder();
         try(
                 FileInputStream fileInputStream = new FileInputStream(file.getName());
                 InputStreamReader reader = new InputStreamReader(fileInputStream , Charset.forName(current));
                 BufferedReader bufferedReader = new BufferedReader(reader)
            ){
             String str;
             while ((str = bufferedReader.readLine()) !=null){
                builder.append(str);
             }
        } catch (IOException e){
             e.printStackTrace();
         }

        try (
                FileOutputStream fileOutputStream =new FileOutputStream(file.getName());
                OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream , Charset.forName(needed));

                ){
            writer.write(builder.toString());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
