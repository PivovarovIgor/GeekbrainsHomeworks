package ru.geekbrains.hw14;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class AppTask1TestParametrized {

    private App app;

    private int[] input;
    private int[] output;

    public AppTask1TestParametrized(int[] input, int[] output) {
        this.input = input;
        this.output = output;
    }

    @Before
    public void init() {
        app = new App();
    }

    @Test
    public void task1() {
        Assert.assertArrayEquals(output, app.task1(input));
    }

    @Parameterized.Parameters(name = "{index}: Array in: {0}, Array out: {1}")
    public static Iterable<Object[]> dataForTask1() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 3, 6, 4, 3, 5, 6}, new int[]{3, 5, 6}},
                {new int[]{4, 3, 5, 6, 0}, new int[]{3, 5, 6, 0}},
                {new int[]{4, 3, 5, 4, 0}, new int[]{0}},
                {new int[]{4, 3, 4, 6, 0}, new int[]{6, 0}}
        });
    }
}