package ru.geekbrains.hw10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;


public class App {

    public static void main(String[] args) {

        App app = new App();

        app.task1();
        app.task2();

    }

    public void task2() {

        System.out.println("========Задача №2========");

        Phonebook phonebook = new Phonebook();

        printGetResult(phonebook, "Иванов");

        printAddResult(phonebook, "Иванов", "+7(985)214-75-");
        printAddResult(phonebook, "Иванов", "  +7 985 214 75 25 ff");
        printAddResult(phonebook, "Иванов", "  +7 985 214 75-25");
        printAddResult(phonebook, "Иванов", "  +79852147525");
        printAddResult(phonebook, "Петров", "  +79990000000");
        printAddResult(phonebook, " ИВаНоВ ", "  +79990000000");

        printGetResult(phonebook, "Иванов");
        printGetResult(phonebook, " иВАНОВ");
        printGetResult(phonebook, "Петров");

    }

    private void printAddResult(Phonebook phonebook, String surname, String phone) {
        try {
            phonebook.add(surname, phone);
            System.out.printf("На фамилию '%s' добавлен номер телефона '%s'\n", surname, phone);
        } catch (PhoneFormatException e) {
            System.out.printf("На фамилию '%s' не удалось добавить телефон '%s'. Причина: %s\n",
                    surname, phone, e.getMessage());
        }
    }

    private void printGetResult(Phonebook phonebook, String surname) {
        System.out.printf("Получить номера телефонов '%s'\n", surname);
        String[] result = phonebook.get(surname);
        Arrays.stream(result).forEach(System.out::println);
        if (result.length == 0) {
            System.out.println("нет номеров телефона");
        }
    }

    public void task1() {

        System.out.println("========Задача №1========");

        ArrayList<String> words = new ArrayList<>();
        words.add("Яблоко");
        words.add("Банан");
        words.add("Слива");
        words.add("Киви");
        words.add("Абрикос");
        words.add("Слива");
        words.add("Яблоко");
        words.add("Черешня");
        words.add("Виноград");
        words.add("ЯБЛОКО");
        words.add("Слива");
        words.add("Яблоко");

        System.out.printf("Дан массив слов: %s\n", words);

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        words.stream()
                .map(String::toLowerCase)
                .forEach(
                        el -> result.put(el, (result.containsKey(el)) ? result.get(el) + 1 : 1)
                );

        System.out.println("Уникальные слова:");
        result.forEach((key, val) -> {
            if (val == 1) System.out.println(key);
        });
        System.out.println("\nЧастота повторения слов:");
        result.forEach((key, val) -> System.out.println("слово '" + key + "' встретилось " + val));
    }
}
