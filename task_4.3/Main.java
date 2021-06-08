/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, по вашему усмотрению
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/


public class Main {
    public static void main(String[] args) {
        Cat maru = new Cat();
        Cat neko = new Cat();
        maru.age = 3;
        maru.weight = 5;
        maru.strength = 8;
        neko.age = 5;
        neko.weight = 5;
        neko.strength = 9;

        System.out.println(maru.fight(neko));
    }
}

class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int me = 0, enemy = 0; // критерии

        if (this.strength > anotherCat.strength)
            me++;
        else if (this.strength < anotherCat.strength)
            enemy++;
        if (this.weight > anotherCat.weight)
            me++;
        else if (this.weight < anotherCat.weight)
            enemy++;
        if (this.age < anotherCat.age)
            me++;
        else if(this.age > anotherCat.age)
            enemy++;
        if (me > enemy)
            return true;
        else
            return false;
    }
}
