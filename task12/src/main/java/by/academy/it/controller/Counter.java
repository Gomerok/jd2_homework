package by.academy.it.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Counter {
    public static void setCount(int count) {
        try (FileWriter fileWriter = new FileWriter(FileCreator.getPath(), false)) {
            fileWriter.write(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getCount() {
        try (FileReader fileReader = new FileReader(FileCreator.getPath())) {
            int count = Integer.parseInt(String.valueOf(fileReader.read()));
            return count;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
