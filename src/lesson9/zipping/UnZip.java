package lesson9.zipping;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {
    private String path;
    private File file;

    public UnZip(String path) {
        this.path = path;
        unzipping();
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

    private void unzipping(){
        byte[] buffer = new byte[1024];


        String dstDirectory = destinationDirectory(path);
        File dstDir = new File(dstDirectory);
        if (!dstDir.exists()) {
            dstDir.mkdir();
        }

        try(
                ZipInputStream zis = new ZipInputStream(
                new FileInputStream(path));
        ) {

            ZipEntry ze = zis.getNextEntry();
            String nextFileName;
            while (ze != null) {
                nextFileName = ze.getName();
                File nextFile = new File(dstDirectory + File.separator
                        + nextFileName);

                if (ze.isDirectory()) {
                    nextFile.mkdir();
                } else {

                    new File(nextFile.getParent()).mkdirs();

                    try (FileOutputStream fos
                                 = new FileOutputStream(nextFile)) {
                        int length;
                        while((length = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
                ze = zis.getNextEntry();
            }
            zis.closeEntry();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String destinationDirectory(String srcZip) {
        return srcZip.substring(0, srcZip.lastIndexOf("."));
    }
}
