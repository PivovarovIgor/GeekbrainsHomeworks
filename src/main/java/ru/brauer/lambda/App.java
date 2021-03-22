package ru.brauer.lambda;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class App {

    private LocalDate hireDay;

    public static void main(String[] args) {

        var arr = new String[]{"Солнце",
                "Меркурий",
                "Венера",
                "Земля",
                "Марс",
                "Юпитер",
                "Сатурн",
                "Уран",
                "Нептун",
                "Плутон",
        };

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new LengthComparator());
        System.out.println(Arrays.toString(arr));

        //сортировка массива
        Arrays.sort(arr, (f, s) -> s.length() - f.length());
        System.out.println(Arrays.toString(arr));
        
        Random rnd = new Random();
        LocalDate day = (rnd.nextInt(5) == 0) ? null : LocalDate.now();
        App app = new App(day);

    }

    App(LocalDate day) {
        //отложенное вычисление
        this.hireDay = Objects.requireNonNullElseGet(day,
                () -> LocalDate.of(1970,1,1));
    }

}
