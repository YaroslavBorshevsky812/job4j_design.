package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> line1 = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            List<String> lines = new ArrayList<String>();
            in.lines().forEach(lines::add);
            for (String line : lines) {
                String[] split = line.split(" ");
                if ("404".equals(split[split.length - 2])) {

                    line1.add(line + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line1;
    }
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("logResult.txt")
                ))) {
            out.write(filter("log.txt" + "\n").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
        save(log, "logResult.txt");

    }
}
