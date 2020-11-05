package io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
//        File file = new File("c:\\projects");
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new
                    IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new
                    IllegalArgumentException(String
                            .format("Not directory %s", file.getAbsoluteFile()));
        }
        for (File f:file.listFiles()) {
            System.out.println(f.getName() + "  - " + f.length());
        }
    }
}
