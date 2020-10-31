package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analizy {

    public static void unavailable(String source, String target) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(source));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)));
            String serverDown = null;
            while (reader.ready()) {
                String s = reader.readLine();
                if (s.startsWith("400") || s.startsWith("500")) {
                    String[]s1 = s.split(" ");
                    writer.println(s1[1]);
                } else {
                    if (!(s.startsWith("500")) || !s.startsWith("400")) {
                        String[]s1 = s.split(" ");
                        writer.println(s1[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
            unavailable("server.log", "resultServer.csv");
        }
    }
