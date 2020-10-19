package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            List<String> lines = new ArrayList<String>();
            List<String> line1 = new ArrayList<>();
            in.lines().forEach(lines::add);
            for (String line : lines) {
                line1 = Arrays.asList(line.split(" "));
                if (line1.get(line1.size() - 2).equals("404") && !(line1.get(line1.size() - 1).equals("-"))) {
                    System.out.println(line1 + "  Длина" + line1.size());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
