package io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analizy {
    public static void unavailable(String source, String target) {
        List<String> lines = new ArrayList<String>();
        String start = null;
        String finish = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(source));
            String s = null;
            while ((s = in.readLine()) != null) {
                if (s.contains("400") || s.contains("500")) {
                    String[] buf = s.split(" ");
                    lines.add(buf[1] + "  finish");
                }
                if (s.contains("200") || s.contains("300")) {
                    String[] buf = s.split(" ");
                    lines.add(buf[1] + "  start");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        unavailable("server.log", "resultServer.csv");
    }
}
