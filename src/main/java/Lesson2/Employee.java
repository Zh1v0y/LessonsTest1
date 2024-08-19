package Lesson2;

public class Employee {

    private String lastName;
    private String firstName;
    private String middleName;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;

    public Employee(String lastName,
                    String firstName,
                    String middleName,
                    String position,
                    String email,
                    String phoneNumber,
                    double salary,
                    int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "\nСотрудник" +
                "\nФИО: " + lastName +
                " " + firstName +
                " " + middleName +
                "\nДолжность: " + position +
                "\nemail: " + email +
                "\nТелефон: " + phoneNumber +
                "\nЗарплата: " + salary +
                "\nВозраст: " + age;
    }

    public void informationOutput() {
        System.out.println(this);
    }
}

