package Lesson2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов",
                "Иван",
                "Петрович",
                "Менеджер",
                "ivanov@example.com",
                "+375291367977",
                1500.94,
                35);
        employees[1] = new Employee("Петров",
                "Петр",
                "Иванович",
                "Разработчик",
                "petrov@example.com",
                "+375299161274",
                2000.74,
                30);
        employees[2] = new Employee("Сидоров",
                "Александр",
                "Сергеевич",
                "Дизайнер",
                "sidorov@example.com",
                "+375296219380",
                1200.43,
                28);
        employees[3] = new Employee("Козлова",
                "Елена",
                "Алексеевна",
                "Бухгалтер",
                "kozlova@example.com",
                "+375297241566",
                1800.51,
                40);
        employees[4] = new Employee("Новикова",
                "Ольга",
                "Михайловна",
                "Тестировщик",
                "novikova@example.com",
                "+375292668790",
                1300.34,
                27);

        Arrays.stream(employees).forEach(Employee::informationOutput);

        Park park = new Park("Гомельский парк аттракционов");
        park.addAttractions("ВАЛЬС", "10:00 - 18:00", 5.00);
        park.addAttractions("Летающий слон", "10:00 - 18:00", 5.50);
        park.addAttractions("Чашечки", "10:00 - 18:00", 3.50);
        park.informationOutput();
    }
}