/*
* Дана коллекция имён.
* 1) удалить все повторяющиеся имена из коллекции
* 2) вывести коллекцию на экран
* */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // для чего здесь сканер не понятно.
        ArrayList<String> names = new ArrayList();
        names.add("Анатолий");
        names.add("Георгий");
        names.add("Руслан");
        names.add("Георгий");
        names.add("Павел");
        names.add("Руслан");

        System.out.println(names);  // вывод заданной коллекции

        int i = 0;
        String name;
        while (names.size() > i){
            name = names.get(i);
            while (names.lastIndexOf(name) != i) {
                names.remove(names.lastIndexOf(name));
            }
            i++;
        }

        System.out.println(names);  // вывод итоговой коллекции
    }
}

