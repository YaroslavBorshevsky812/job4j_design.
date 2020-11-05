package io;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;
import java.util.StringJoiner;


public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void period() throws IOException {
        File source = folder.newFile("server.log");
        File target = folder.newFile("resultServer.csv");
        String ls = System.lineSeparator();
        try (PrintWriter out = new PrintWriter(source)) {
            out.write("200 10:56:01"
                    + ls
                    +    "500 10:57:01"
                    + ls
                    +    "400 10:58:01"
                    + ls
                    +    "200 10:59:01"
                    + ls
                    +    "500 11:01:02"
                    + ls
                    +    "200 11:02:02");
        }
        Analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringJoiner rsl = new StringJoiner(System.lineSeparator());
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::add);
        }
        assertThat(rsl.toString(), is(
                "10:57:01;10:59:01"
                        + ls
                        +   "11:01:02;11:02:02"));
    }

}