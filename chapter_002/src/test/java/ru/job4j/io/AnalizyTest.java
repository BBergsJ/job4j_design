package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class AnalizyTest {

    @Test
    public void whenPairWithoutComment() {
        String source = "server.log";
        String target = "unavailable.log";
        Analizy test = new Analizy();
        test.unavailable(source, target);


    }

}