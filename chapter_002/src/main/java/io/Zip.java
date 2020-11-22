package io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.*;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            Iterator<Path> it = sources.iterator();
            while (it.hasNext()) {
                zip.putNextEntry(new ZipEntry(it.next().toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(it.next().toFile()))) {
                    zip.write(out.readAllBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        argZip.setValue();
        List<Path> paths = SimpleSearch.search(Paths.get(argZip.getValue("d")), argZip.getValue("e"));
        new Zip().packFiles(paths, new File(argZip.getValue("o")));
    }
}

