package ru.geekbrains.hw09;

import java.util.Arrays;

public class App {

    private final int ARRAY_SIZE = 4;

    public static void main(String[] args) {

        App app = new App();

        app.printResult(new String[][]{
                {"243", "232"},
                {"24", "32"}
        });

        app.printResult(new String[][]{
                {"243", "232", "35", "-54"},
                {"24", null, "-546", "545"},
                {"-24", "32", "-6", "545"},
                {"24", "3", "0", "545"},
        });

        app.printResult(new String[][]{
                {"243", "232", "35", "-54"},
                {"24", "0", "-", "545"},
                {"-24", "32", "-6", "545"},
                {"24", "3", "0", "545"},
        });

        app.printResult(new String[][]{
                {"2", "32", "35", "-54"},
                {"24", "32", "-546", "545"},
                {"-24", "32", "-6", "5"},
                {"24", "3", "0", "545"},
        });

    }

    public void printResult(String[][] arr) {

        System.out.printf("Попытка суммирования массива:\n%s\n",
                Arrays.deepToString(arr)
                        .replace("[[", "[")
                        .replace("], ", "]\n")
                        .replace("]]", "]")
        );

        try {
            System.out.printf("Сумма элементов = %d", sumStringArray(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.printf("Не удалось выполнить суммирование массива по причине: %s\n", e.getMessage());
        }

    }

    public int sumStringArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (!checkSizeArray(arr)) {
            throw new MyArraySizeException(
                    String.format("Размер массива не соответствует требованию %dx%d", ARRAY_SIZE, ARRAY_SIZE)
            );
        }

        int sum = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Значение '%s' в ячейке [%d][%d] не удалось прелобразовать в число.",
                                    arr[i][j], i + 1, j + 1));
                }
            }
        }
        return sum;
    }

    private boolean checkSizeArray(String[][] arr) {
        if (arr.length != ARRAY_SIZE) {
            return false;
        }
        for (String[] ln : arr) {
            if (ln.length != ARRAY_SIZE) {
                return false;
            }
        }
        return true;
    }
}
