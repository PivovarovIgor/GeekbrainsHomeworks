package ru.geekbrains.hw14;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {

        try {
            performApp();
        } catch (Exception e) {
            LOGGER.fatal(Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }
    }

    private static void performApp(){
        App app = new App();

        System.out.println(Arrays.toString(app.task1(new int[]{3, 5, 6, 7, 4, 5, 7, 8})));
        //System.out.println(Arrays.toString(app.task1(new int[]{3, 5, 6, 7, 5, 5, 7, 8}))); //здесь моделируем падение приложения
        System.out.print(app.task2(new int[]{3, 4, 6, 7, 1, 5, 7, 8}));
    }

    public int[] task1(int[] arr) {

        LOGGER.trace("Метод task1 входные данные " + Arrays.toString(arr));
        int[] res;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                res = new int[arr.length - i - 1];
                System.arraycopy(arr, i + 1, res, 0, res.length);
                LOGGER.trace("Метод task1 результат " + Arrays.toString(res));
                return res;
            }
        }
        throw new RuntimeException("В массиве нет четвёрки.");
    }

    public boolean task2(int[] arr) {

        LOGGER.trace("Метод task2 входные данные " + Arrays.toString(arr));
        return Arrays.stream(arr)
                .filter(el -> el == 1 || el == 4)
                .distinct()
                .count() == 2;
    }

}
