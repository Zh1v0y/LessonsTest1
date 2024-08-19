package Lesson2;

import java.util.ArrayList;
import java.util.List;

public class Park {

    private String name;
    private List<Attraction> attractions;

    public Park(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
    }

    public void addAttractions(String name, String workingHours, double price) {
        attractions.add(new Attraction(name, workingHours, price));
    }

    @Override
    public String toString() {
        return "\n" + name;
    }

    public void informationOutput() {
        System.out.println(this + "\nАттракционы: ");
        attractions.forEach(System.out::println);
    }

    public class Attraction {

        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Аттракцион [" +
                    "Название: " + name +
                    ", Время работы: " + workingHours +
                    ", Стоимость: " + price +
                    "]";
        }
    }


}

