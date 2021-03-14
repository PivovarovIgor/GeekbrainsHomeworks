package ru.geekbrains.hw04;

import java.util.Random;
import java.util.Scanner;

public class BattleshipGame {
    private static final int EMPTY = 0;
    private static final int SHIP = 1;
    private static final int HIT_SHIP = -1;
    private static final int HIT = -2;

    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_SHIPS = 10;

    public static void main(String[] args) {
        System.out.println("""
                            Привет!
                     Сыграем в морской бой!
                """);
        do {
            int size = DEFAULT_SIZE;
            int ships = DEFAULT_SHIPS;
            if (args.length == 2) {
                size = Integer.parseInt(args[0]);
                ships = Integer.parseInt(args[1]);
            }
            if (!play(size, ships)) {
                return;
            }
        } while (isPlayAgain());
    }

    private static boolean isPlayAgain() {
        Scanner sc = new Scanner(System.in);
        int answer;
        do {
            System.out.print("Игра окончена.\nСыграем еще (0 - нет / 1 - да)? ");
            answer = sc.nextInt();
        } while (answer != 1 && answer != 0);
        return answer == 1;
    }

    private static boolean play(int size, int ships) {
        int[][] board = generateBoard(size, ships);
        if (board == null) {
            System.out.printf("Не удалось выполнить размещение кораблей в количестве %d игровое поле %d X %d. Задайте более приемлемые параметры.", ships, size, size);
            return false;
        }
        int decks = decksCount(board);
        while (decks > 0) {
            printBoard(board);
            boolean isHit = makeMove(board);
            if (isHit) {
                System.out.println("\nПопал!");
                --decks;
            } else {
                System.out.println("\nПромазал!");
            }
        }
        return true;
    }

    private static int decksCount(int[][] board) {
        int result = 0;
        for (int[] ints : board) {
            for (int cell : ints) {
                result += (cell == SHIP) ? 1 : 0;
            }
        }
        return result;
    }

    private static boolean makeMove(int[][] board) {
        int row, line;
        int size = board[0].length;
        System.out.print("\nВаш ход: ");
        Scanner sc = new Scanner(System.in);
        do {
            String move = sc.nextLine().toUpperCase();
            row = move.charAt(0) - 'A';
            line = Integer.parseInt(move.substring(1)) - 1;
        } while (row < 0 || row >= size || line < 0 || line >= size);
        if (board[line][row] == SHIP) {
            board[line][row] = HIT_SHIP;
            return true;
        }
        board[line][row] = HIT;
        return false;
    }

    private static int[][] generateBoard(int size, int ships) {
        int[][] board = new int[size][size];
        int[] numberOfDecks = new int[]{ships / 3, ships / 5, ships / 10};
        int decks = checkNextDecks(numberOfDecks);
        Random rnd = new Random();
        for (int i = ships - 1; i >= 0; i--) {
            int i1;
            int i2;
            int attempts = 50;

            do {
                if (attempts == 0) {
                    return null; // не удаётся разместить корабли
                }
                attempts--;

                i1 = rnd.nextInt(size);
                i2 = rnd.nextInt(size);
            } while (!setShip(board, decks, i1, i2));
            if (decks > 1) {
                numberOfDecks[decks - 2]--;
                decks = checkNextDecks(numberOfDecks);
            }
        }
        return board;
    }

    private static int checkNextDecks(int[] numberOfDecks) {
        for (int i = numberOfDecks.length - 1; i >= 0; i--) {
            if (numberOfDecks[i] > 0) {
                return i + 2;
            }
        }
        return 1;
    }

    private static boolean setShip(int[][] board, int decks, int i1, int i2) {

        Random rnd = new Random();
        int vertical = rnd.nextInt(2);
        int horizontal = (vertical == 0) ? 1 : 0;

        int length = board.length;
        if (horizontal == 1) {
            length = board[i1].length;
        }
        if (decks + ((horizontal == 1) ? i2 : i1) - 1 > length - 1) {
            return false;
        }

        for (int i = 0; i < decks; i++) {
            if (!checkToSetDeck(board, i1 + i * vertical, i2 + i * horizontal)) {
                return false;
            }
        }
        for (int i = 0; i < decks; i++) {
            board[i1 + i * vertical][i2 + i * horizontal] = SHIP;
        }

        return true;
    }

    private static boolean checkToSetDeck(int[][] board, int i1, int i2) {
        for (int i = Math.max(i1 - 1, 0); i <= Math.min(i1 + 1, board.length - 1); i++) {
            for (int j = Math.max(i2 - 1, 0); j <= Math.min(i2 + 1, board[i].length - 1); j++) {
                if (board[i][j] == SHIP) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        System.out.print("    ");
        for (char i = 'A'; i < board[0].length + 'A'; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        int i = 0;
        for (int[] lines : board) {
            System.out.printf("%3d ", ++i);
            for (int cell : lines) {
                switch (cell) {
                    case EMPTY:
                        System.out.print(" . ");
                        break;
                    case SHIP:
                        System.out.print("[ ]");
                        break;
                    case HIT:
                        System.out.print(" x ");
                        break;
                    case HIT_SHIP:
                        System.out.print("[X]");
                        break;
                }
            }
            System.out.println();
        }
    }
}
