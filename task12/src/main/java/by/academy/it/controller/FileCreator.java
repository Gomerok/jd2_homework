package by.academy.it.controller;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    private static String path = null;
    private static final String FILE_NAME = "\\test.txt";

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        FileCreator.path = path;
    }

    public static void createFile() {
        path = System.getProperty("user.dir") + FILE_NAME;
        File countFile = new File(path);
        try {
            if (!countFile.exists()) {
                countFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
