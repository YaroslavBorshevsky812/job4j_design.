package io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SimpleSearch {
    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(ext);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    static class SearchFiles extends SimpleFileVisitor<Path> {
        private List<Path> pathsList = new ArrayList<>();
        private String str;
        SearchFiles(String ext) {
            this.str = ext;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!file.getFileName().toString().endsWith(str)) {
                pathsList.add(file);
            }
            return super.visitFile(file, attrs);
        }
        public List<Path> getPaths() {
            return pathsList;
        }
    }
}

