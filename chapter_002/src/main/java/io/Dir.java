package io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
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