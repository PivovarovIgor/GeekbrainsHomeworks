package ru.brauer.lambda;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {

    private final int OFFSET = 1000;

    @Override
    public int compare(String f, String s) {
        return (f.length() * OFFSET - s.length() * OFFSET) + f.compareTo(s);
    }
}
