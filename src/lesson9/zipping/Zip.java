package lesson9.zipping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
 private String path;
    private String dest;
    private File file;
    private File fileOut;

    public Zip(String path, String dest) {
        this.path = path;
        this.dest = dest;
        file = new File(dest);
        fileOut = new File(path);
        zipping();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private void zipping(){
        File files[] = fileOut.listFiles();
        try(
                ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file.getPath()+".zip"));
                FileInputStream fis = new FileInputStream(file);
        ) {

            for (File file: files) {
                ZipEntry ze = new ZipEntry(file.getName());
                zos.putNextEntry(ze);
                byte [] buffer = new byte[fis.available()];
                fis.read(buffer);
                zos.write(buffer);
                zos.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
