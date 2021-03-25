package ru.geekbrains.hw10;

import java.util.*;

public class Phonebook {

    private final int MIN_LENGTH_PHONE = 11;

    private HashMap<String, LinkedHashSet<String>> elements = new HashMap<>();

    public void add(String surname, String phone) {
        surname = correctKey(surname);
        phone = correctValue(phone);
        validatePhone(phone);
        if (!elements.containsKey(surname)) {
            elements.put(surname, new LinkedHashSet<>());
        }
        elements.get(surname).add(phone);
    }

    public String[] get(String surname) {
        LinkedHashSet<String> result = elements.getOrDefault(
                correctKey(surname),
                new LinkedHashSet<>()
        );
        return result.toArray(new String[0]);
    }

    private String correctKey(String key) {
        return key.trim()
                .toLowerCase();
    }

    private void validatePhone(String phone) {
        if (phone.length() < MIN_LENGTH_PHONE) {
            throw new PhoneFormatException(
                    String.format("В номере телефона должно быть не менее %d цифр",
                            MIN_LENGTH_PHONE));
        }
        char[] chars = phone.toCharArray();
        for (char ch : chars) {
            if (ch < '0' || ch > '9') {
                throw new PhoneFormatException("Номер телефона должен содержать только цифры.");
            }
        }
    }

    private String correctValue(String value) {
        return value.trim()
                .replace(" ", "")
                .replace("-", "")
                .replace("(", "")
                .replace(")", "")
                .replace("+", "");
    }
}
