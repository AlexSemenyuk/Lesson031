package org.itstep;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UUUU {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        System.out.println("one".hashCode());
        System.out.println("two".hashCode());
        set.add("one");
        set.add("two");
        set.add("two");
        set.add("three");
        set.add("three");
        set.add("four");
        set.add("four");
        set.add("five");
        System.out.println(set);

        Set<Car> cars = new HashSet<>();
        Car car1 = new Car("Model X", "Tesla", "White", 50000);
        Car car2 = new Car("Model X", "Tesla", "White", 50000);
        System.out.println("car1 == car2 " + (car1 == car2));
        System.out.println("car1.equals(car2) " + car1.equals(car2));
        System.out.println("car.hashCode() = " + car1.hashCode() + " car2.hashCode() = " + car2.hashCode());
    }

    public  void mainRRRR() {
        List<Car> cars = new ArrayList<>();
        // 1. Добавление объекта в список
        cars.add(new Car("A8", "Audi", "Grey", 25_000));    // Добавить в конец списка
        cars.addAll(List.of(new Car("Dacha", "Renault", "Black", 15_000),   // Добавление списка
                new Car("S500", "Mersedes", "White", 105_000),
                new Car("X6", "BMW", "Red", 65_000)));
        cars.add(0, new Car("Accent", "Hyundai", "Grey", 18_000)); // Добавление в 0 позицию

        System.out.println(cars);           // Вывод в строку всего списка
        System.out.println("-----------------------------------------------------------");
        for (Car car : cars) {
            System.out.println(car);        // Вывод в столбик
        }
        // Сохранение существующего списка со ссылками в другом списке
        List<Car> original = new ArrayList<>(cars);
        // 2. Удаление объекта из списка
        cars.remove(1);     // Удаление по индексу, остаток сзади сдвигается на 1
        System.out.println("-----------------------------------------------------------");
        for (Car car : cars) {
            System.out.println(car);        // Вывод в столбик
        }

        // Удаление объекта, остаток сзади сдвигается на 1 (работает если переопределен .equals())
        cars.remove(new Car("S500", "Mersedes", "White", 105_000));
        System.out.println("-----------------------------------------------------------");
        for (Car car : cars) {
            System.out.println(car);        // Вывод в столбик
        }
        // Удаление объекта через копию объекта (вместе с ссылкой, переопределение .equals() не нужно)
        Car car1 = cars.get(2);
        cars.remove(car1);  // По умолчанию .equals() проверяет ссылку
        System.out.println("-----------------------------------------------------------");
        for (Car car : cars) {
            System.out.println(car);        // Вывод в столбик
        }
        // Удаляет все экземпляры списка, соответствующие условию
        cars.removeIf(new Predicate<Car>() {        // имплементируют интерфейс Predicate (писать new Pre)
            @Override
            public boolean test(Car car) {          // метод возвращает все экземпляры, соотв. условию
                return car.getPrice() <= 15000;     // условие, которое должно быть выполнено
            }
        });

        // Удаляет все экземпляры списка, соответствующие 2 условиям (набираем .or ) - Двойной removeIf
        cars.removeIf(new Predicate<Car>() {        // имплементируют интерфейс Predicate (писать new Pre)
            @Override
            public boolean test(Car car) {          // метод возвращает все экземпляры, соотв. условию
                return car.getPrice() <= 10000;     // условие, которое должно быть выполнено
            }
        }.or(new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("Yellow");
            }
        }));

        System.out.println("-----------------------------------------------------------");
        for (Car car : cars) {
            System.out.println(car);        // Вывод в столбик
        }

        // 3. Замена объекта в списке (или данных объекта)
        original.get(2).setPrice(16_000);        // Изменение поля экземпляра с индексом 2
        // Изменение поля экземпляра с индексом 2 через переменную
//        Car car2 =  original.get(2);          // Получение ссылки в переменной car2
//        car2.setPrice(16_000);                // Изменение поля экземпляра со ссылкой (переменная car2)
        System.out.println("-----------------------------------------------------------");
        for (Car orig : original) {
            System.out.println(orig);        // Вывод в столбик
        }
        // замена экземпляра списка с индексом 3 на новый объект
        original.set(3, new Car("F50", "Ferrari", "Yellow", 500_000));
        System.out.println("-----------------------------------------------------------");
        for (Car orig : original) {
            System.out.println(orig);        // Вывод в столбик
        }
        // 4. Поиск объекта в списке
        // Получение индекса объекта (работает когда переопределен .equals())
        int index = original.indexOf(new Car("Dacha", "Renault", "Black", 16_000));
        if (index >= 0) {
            System.out.println("index=" + index);       // -1 - нет такого экземпляра, цифра от 0 - индекс объекта
        }

        // 5. Сортировка
        // сортировка по цене через анонимный класс (набирать new Com)
        original.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        System.out.println("-----------------------------------------------------------");
        for (Car orig : original) {
            System.out.println(orig);        // Вывод в столбик
        }
        // сортировка по производителю через переменную (набирать new Com)
        Comparator<Car> comparatorByMade = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getMade().compareTo(o2.getMade());
            }
        };
        original.sort(comparatorByMade);
        System.out.println("-----------------------------------------------------------");
        for (Car orig : original) {
            System.out.println(orig);        // Вывод в столбик
        }

        // обычный foreach. (набирать new Con)
        System.out.println("-----------------------------------------------------------");
        original.forEach(new Consumer<Car>() {
            @Override
            public void accept(Car car) {
                System.out.println(car);
            }
        });

                // Использовать можно двойной, например для увеличения цены всем на 10% или др.
                System.out.println("-----------------------------------------------------------");
        original.forEach(new Consumer<Car>() {
            @Override
            public void accept(Car car) {
                car.setPrice(car.getPrice() * 1.1);       // увеличение цены всем на 10%
            }
        }.andThen(new Consumer<Car>() {
            @Override
            public void accept(Car car) {
                System.out.println(car);
            }
        }));


    }
}

class Car {
    private String model;
    private String made;
    private String color;
    private double price;

    public Car(String model, String made, String color, double price) {
        this.model = model;
        this.made = made;
        this.color = color;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car car) {
            return model.equals(car.model) && made.equals(car.made) && color.equals(car.color) && price == car.price;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return (int) (model.hashCode() + made.hashCode() + color.hashCode() + price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", made='" + made + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}