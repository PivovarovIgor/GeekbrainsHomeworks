package ru.geekbrains.hw11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App {

    public static void main(String[] args) {

        App app = new App();

        app.task1();
        app.task2();
        app.task3();
    }

    public void task1() {

        String[] arr1 = new String[]{"Яблоко", "Киви", "Банан"};
        System.out.println(Arrays.toString(arr1));
        swap(arr1, 0, 2);
        System.out.println(Arrays.toString(arr1));

        Integer[] arr2 = new Integer[]{1, 2, 3};
        System.out.println(Arrays.toString(arr2));
        swap(arr2, 0, 2);
        System.out.println(Arrays.toString(arr2));

    }

    private <T> void swap(T[] arr, int firstInd, int secondInd) {
        if (firstInd == secondInd
                || arr.length < 2
                || firstInd < 0
                || secondInd < 0
                || firstInd >= arr.length
                || secondInd >= arr.length) {
            return;
        }
        T el = arr[firstInd];
        arr[firstInd] = arr[secondInd];
        arr[secondInd] = el;
    }

    public void task2() {

        String[] arr1 = new String[]{"Яблоко", "Киви", "Банан"};
        System.out.println(Arrays.toString(arr1));
        System.out.println(toArrayList(arr1));

        Integer[] arr2 = new Integer[]{1, 2, 3};
        System.out.println(Arrays.toString(arr2));
        System.out.println(toArrayList(arr2));

    }

    private <T> ArrayList<T> toArrayList(T[] arr) {
        ArrayList<T> arrList = new ArrayList<>();
        Collections.addAll(arrList, arr);
        return arrList;
    }

    public void task3() {

        //Box boxOfApples = new Box(); - такое компилятор позволяет создать. Возможно ли это как-то ограничить?
        Box<Apple> boxOfApples = new Box<>("A");
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple());
        //boxOfApples.add(new Orange()); - компилятор ругается
        System.out.printf("%s вес %f\n", boxOfApples, boxOfApples.getWeight());

        Box<Orange> boxOfOranges = new Box<>("B");
        boxOfOranges.add(new Orange());
        System.out.printf("%s вес %f\n", boxOfOranges, boxOfOranges.getWeight());

        Box<Apple> boxOfApples2 = new Box<>("C");
        boxOfApples2.add(new Apple());
        boxOfApples2.add(new Apple());
        boxOfApples2.add(new Apple());
        System.out.printf("%s вес %f\n", boxOfApples2, boxOfApples2.getWeight());
        System.out.printf("Сравниваем %s и %s, результат: %b\n", boxOfApples, boxOfApples2, boxOfApples.compare(boxOfApples2));
        System.out.printf("Сравниваем %s и %s, результат: %b\n", boxOfApples, boxOfOranges, boxOfApples.compare(boxOfOranges));

        boxOfApples.pourTo(boxOfApples2);
        System.out.printf("Пересыпали %s -> %s результат %s %s\n", boxOfApples.getName(), boxOfApples2.getName(), boxOfApples, boxOfApples2);
        //boxOfApples2.pourTo(boxOfOrange); - компилятор ругается
    }
}