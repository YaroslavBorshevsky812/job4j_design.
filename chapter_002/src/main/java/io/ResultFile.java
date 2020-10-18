package io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        int k = 1;
        int x = 1;
        try (FileOutputStream out = new FileOutputStream("Matrix.txt")) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    table[i][j] = (i + 1) * (j + 1);
                    out.write((table[i][j] + " ").getBytes());
                }
                out.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }
    public static void main(String[] args) {
        multiple(10);
    }
}