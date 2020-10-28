package io;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
                while ((read.readLine()) != null) {
                    read.readLine();
                    String s = read.readLine();
                    if (!(s.isEmpty() || s.startsWith("#"))) {
                    String[] s1 = s.split("=");
                    if (s.length() >= 2) {
                        values.put(s1[0], s1[1]);
                    }
                }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Config("./chapter_002/src/main/resources/app.properties"));
    }
}