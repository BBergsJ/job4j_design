package ru.job4j.io;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class AnalizyTest {

    @Test
    public void whenWriteFromServerLog() throws IOException {
        File source = new File("./src/main/resources/server.log");
        File target = new File("./src/main/resources/unavailable.log");

        Files.write(source.toPath(), List.of(
                "200 10:56:01",
                "500 10:57:01",
                "400 10:58:01",
                "200 10:59:01",
                "500 11:01:02",
                "200 11:02:02"
        ));

        Analizy analizy = new Analizy();
        analizy.unavailable(source.getPath(), target.getPath());
        List<String> expected = List.of("10:57:01;10:59:01", "11:01:02;11:02:02");
        List<String> result = Files.readAllLines(target.toPath());
        assertThat(result, is(expected));
    }
}