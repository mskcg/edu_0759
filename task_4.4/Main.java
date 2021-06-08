/*
Создай классы Dog, Cat, Mouse.
Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse("Jerry", 12 , 5),
где 12 - высота в см,
5 - длина хвоста в см.
Требования:
•	Создай класс Dog.
•	Создай класс Cat.
•	В классе Dog должно быть три переменные.
•	В классе Cat должно быть три переменные.
•	Должен быть создан хотя бы один объект типа Mouse.
•	Должен быть создан хотя бы один объект типа Dog.
•	Должен быть создан хотя бы один объект типа Cat.
*/

public class Main {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Mouse muscleMouse = new Mouse("Muscle", 12, 5);
        Cat butchCat = new Cat("Butch", "black", false);
        Cat tomCat = new Cat("Tom", "gray", true);
        Cat pussyCat = new Cat("PussyCat", "white", true);
        Dog spikeDog = new Dog("Spike", "bulldog", 12);
    }
}
class Mouse {
    String name;
    int height;
    int tail;

    public Mouse(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}
class Cat {
    String name;
    String color;
    Boolean domestic;

    public Cat (String name, String color, Boolean domestic) {
        this.name = name;
        this.color = color;
        this.domestic = domestic;
    }
}

class Dog {
    String name;
    String breed;
    int weight;

    public Dog (String name, String breed, int weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }
}
