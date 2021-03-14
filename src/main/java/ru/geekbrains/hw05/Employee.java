package ru.geekbrains.hw05;

public class Employee {

    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void print() {
        System.out.printf("ФИО: '%s', должность: '%s', E-mail: '%s', телефон: '%s', зарплата: '%f', возраст: '%d'\n",
                fullName, position, email, phone, salary, age);
    }

    public int getAge() {
        return age;
    }
}
