package lesson9;


import java.io.File;

public class FileDemo {
    public static void main(String[] args) throws  Exception {

        showTree("F:/JavaWorkSpace/JD");

    }
    public static void showTree(final String dirName){
        File dir = new File(dirName);
        if (!dir.isDirectory()){
            return;
        }

        File files[] = dir.listFiles();
        for (File file : files){
            System.out.println(file.getName());
            if (file.isDirectory()){
                showTree(file.getName());
            }
        }
    }
}
