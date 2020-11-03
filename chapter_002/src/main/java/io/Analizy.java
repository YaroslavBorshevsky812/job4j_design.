package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analizy {

    public static void unavailable(String source, String target) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(source));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(
                    new FileOutputStream(target)))) {
            String serverDown = null;
            while (reader.ready()) {
                String status = reader.readLine();
                if (serverDown == null && (status.startsWith("400") || status.startsWith("500"))) {
                    writer.write(status.split(" ")[1] + ";");
                    serverDown = status;
                } else if (serverDown != null && (!status.isEmpty()
                        && !status.startsWith("400") && !status.startsWith("500"))) {
                    writer.write(status.split(" ")[1]);
                    serverDown = null;
                    writer.println();
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
