package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    String s = j + " * " + i + " = " + (j * i) + System.lineSeparator();
                    out.write(s.getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}