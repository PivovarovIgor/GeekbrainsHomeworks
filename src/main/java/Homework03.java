import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework03 {

    //* Создать массив из слов
    //String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
    //"cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
    //"peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если
    //слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно можно пользоваться:
    //String str = "apple";
    //char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово.
    //Используем только маленькие буквы.

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random rnd = new Random();
        String askWord = words[rnd.nextInt(words.length)];

        char[] guessedLetters = new char[15];
        Arrays.fill(guessedLetters, '#');

        System.out.printf("Компьютером загадано одно слово из списка слов:\n%s\nОтгадайте загаданное слово\n", Arrays.toString(words));

        Scanner scn = new Scanner(System.in);

        while (true) {

            String answer = scn.next().toLowerCase();

            if (askWord.equals(answer)) {
                System.out.printf("Поздравляю! Вы отгадали загаданное слово: '%s'\n", answer);
                break;
            }

            for (int i = 0; i < answer.length() && i < askWord.length(); i++) {
                if (askWord.charAt(i) == answer.charAt(i)) {
                    guessedLetters[i] = askWord.charAt(i);
                }
            }
            System.out.printf("%s Ваш ответ: '%s' - ошибочный\n", new String(guessedLetters), answer);
        }
    }
}
