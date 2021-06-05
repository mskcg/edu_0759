/*
Реализуй в классе Fox интерфейс Animal.
Поменяй код так, чтобы в классе Fox был только один метод - getName.
Учти, что создавать дополнительные классы и удалять методы нельзя!

Требования:
•	Интерфейс Animal должен быть реализован в классе Fox.
•	В интерфейсе Animal нужно объявить метод getColor.
•	Дополнительные классы или интерфейсы создавать нельзя.
*/

import java.awt.*;

public class Main {
    public static void main(String[] args){
    }
}

// условие задачи не совсем понятно. Реализовать интерфейс Animal нужно в классе Fox, но при этом в классе fox только один метод getName?

abstract interface Animal {
    default Color getColor() {
        return Color.WHITE;
    };
}
    
class Fox implements Animal {
    public String getName() {
        return "Fox";
    }
}
