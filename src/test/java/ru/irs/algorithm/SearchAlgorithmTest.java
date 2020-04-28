package ru.irs.algorithm;

import algorithm.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class SearchAlgorithmTest {

    private final List<Searchable> algorithms = asList(
            new RabinKarpSearch(),
            new KnutMorrisPrattSearch(),
            new BoyerMooreSearch(),
            new FiniteAutomataSearch(),
            new LinearSearch()
    );

    @Test
    public void methodShouldReturnCorrectStartIndexOfSubstring() {
        algorithms.forEach(algorithm -> {
            Assert.assertEquals(0, algorithm.search("test", "t"));
            Assert.assertEquals(0, algorithm.search("test", "te"));
            Assert.assertEquals(0, algorithm.search("test", "test"));
            Assert.assertEquals(1, algorithm.search("test", "e"));
            Assert.assertEquals(2, algorithm.search("test", "s"));
        });
    }

    @Test
    public void textShouldNotContainsWrongSubstring() {
        algorithms.forEach(algorithm -> {
            Assert.assertEquals(-1, algorithm.search("test", "tset"));
            Assert.assertEquals(-1, algorithm.search("test", "ts"));
            Assert.assertEquals(-1, algorithm.search("test", "fff"));
            Assert.assertEquals(-1, algorithm.search("test", null));
            Assert.assertEquals(-1, algorithm.search(null, "test"));
        });
    }
}
