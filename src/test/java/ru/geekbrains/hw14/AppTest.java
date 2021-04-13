package ru.geekbrains.hw14;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private App app;

    @Before
    public void init() {
        app = new App();
    }

    @Test
    public void task1Val1() {
        Assert.assertArrayEquals(new int[]{3, 5, 6}, app.task1(new int[]{1, 4, 3, 6, 4, 3, 5, 6}));
    }

    @Test
    public void task1Val2() {
        Assert.assertArrayEquals(new int[]{3, 5, 6, 0}, app.task1(new int[]{4, 3, 5, 6, 0}));
    }

    @Test
    public void task2Val1() {
        Assert.assertEquals(true, app.task2(new int[]{1, 4, 3, 6, 4, 3, 5, 6}));
    }

    @Test
    public void task2Val2() {
        Assert.assertEquals(false, app.task2(new int[]{4, 3, 5, 6, 0}));
    }

    @Test
    public void task2Val3() {
        Assert.assertEquals(false, app.task2(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void task2Val4() {
        Assert.assertEquals(false, app.task2(new int[]{}));
    }

    @Test
    public void task1AssertThrowException() {
        Assert.assertThrows(RuntimeException.class, () -> app.task1(new int[]{1, 2, 5, 6}));
    }

}
