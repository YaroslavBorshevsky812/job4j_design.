package io;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
public class ArgZip {
    private Map<String, String> map = new HashMap<>();

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        File file = new File(directory());
        return file.isDirectory();
    }

    public String directory() {
        String[] str = args[3].split("=");
        if (str[1].isEmpty()) {
            throw new IllegalArgumentException("Отсутствует "
                    + "путь к исходной папке");
        }
        return str[1];
    }

    public String exclude() {
        String[] str = args[4].split("=");
        if (str[1].isEmpty()) {
            throw new IllegalArgumentException("Отсутствует "
                    + "параметр Исключение файлов по расширению");
        }
        return str[1];
    }

    public String output() {
        String[] str = args[5].split("=");
        if (str[1].isEmpty()) {
            throw new IllegalArgumentException("Имя "
                    + "выходного файла не задано");
        }
        return str[1];
    }

    public void setValue() {
        map.put("d", directory());
        map.put("e", exclude());
        map.put("o", output());
    }
    public String getValue(String key) {
        return map.get(key);
    }
}