package ru.geekbrains.hw05;

public class Homework05 {

    public static void main(String[] args) {
        performHomework05();
    }

    private static void performHomework05() {

        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Иванов Иван Иванович",
                "Инженер",
                "ivanovii@compani.ru",
                "+79852347865",
                80000,
                25);
        empArray[1] = new Employee("Пертров Пётр Пертович",
                "Повар",
                "petrovpp@compani.ru",
                "+79999999999",
                75000,
                45);
        empArray[2] = new Employee("Пертрова Анастасия Викторовна",
                "Бухгалтер",
                "petrovaav@compani.ru",
                "+78889854588",
                50000,
                35);
        empArray[3] = new Employee("Пирогов Валерий Сергеевич",
                "Программист",
                "pirogovvs@compani.ru",
                "+7212541215",
                180000,
                50);
        empArray[4] = new Employee("Чичинкин Сергей Сергеевич",
                "Системный администратор",
                "chichinkinss@compani.ru",
                "+72521554111",
                100000,
                33);

        for (Employee emp : empArray) {
            if (emp.getAge() >= 40) {
                emp.print();
            }
        }
    }
}
