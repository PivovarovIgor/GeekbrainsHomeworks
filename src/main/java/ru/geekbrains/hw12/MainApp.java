package ru.geekbrains.hw12;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainApp {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {

        MainApp app = new MainApp();

        float[] arr1 = app.method1();
        float[] arr2 = app.method2();

        //тест на равенство конечного результата
        System.out.println("Сравнение результатов двух методов: " + Arrays.equals(arr1, arr2));
    }

    private float[] createArray() {
        float[] floatArray = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            floatArray[i] = 1.0f;
        }
        return floatArray;
    }

    private void calculateArray(float[] floatArray) {
        calculateArray(floatArray, 0);
    }

    private void calculateArray(float[] floatArray, int offset) {
        for (int i = offset, j = 0; j < floatArray.length; i++, j++) {
            floatArray[j] = (float) (floatArray[j] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
    }

    public float[] method1() {

        float[] floatArray = createArray();
        long a = System.currentTimeMillis();
        calculateArray(floatArray);
        System.out.println("время однопоточного вычисления: " + (System.currentTimeMillis() - a));
        //System.out.println(Arrays.toString(floatArray));
        return floatArray;
    }

    private float[] method2() {

        float[] floatArray = createArray();

        long a = System.currentTimeMillis();

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[SIZE - HALF]; //если вдруг нечётный SIZE
        System.arraycopy(floatArray, 0, arr1, 0, arr1.length);
        System.arraycopy(floatArray, HALF, arr2, 0, arr2.length);

        //calculateArray(floatArray);
        ExecutorService exeSrv = Executors.newFixedThreadPool(2);
        exeSrv.execute(() -> calculateArray(arr1));
        exeSrv.execute(() -> calculateArray(arr2, arr1.length));

        //далее ожидаем завершение всех потоков
        exeSrv.shutdown();
        try {
            exeSrv.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, floatArray, 0, arr1.length);
        System.arraycopy(arr2, 0, floatArray, HALF, arr2.length);

        System.out.println("время двупоточного вычисления: " + (System.currentTimeMillis() - a));
        //System.out.println(Arrays.toString(floatArray));
        return floatArray;
    }
}
