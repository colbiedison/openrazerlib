package co.k42.openrazerlib;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class IO {

    public static void writeFile(File file, String data) throws IOException {
        FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        bos.write(data.getBytes());

        bos.close();
    }

    public static void writeFile(File file, int[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i]);
//            System.out.print(" ");
            bos.write(data[i]);
        }
//        System.out.println();
        bos.close();
    }



    public static byte[] readFile(String filePath) throws IOException {
        Path p = FileSystems.getDefault().getPath(filePath);
        byte[] data = Files.readAllBytes(p);
        return data;
    }

    public static byte[] readFile(File file) throws IOException {
        String path = file.getAbsolutePath();
        Path p = FileSystems.getDefault().getPath(path);
        byte[] data = Files.readAllBytes(p);
        return data;
    }
}
