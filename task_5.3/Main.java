/*
* Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
* Коллекции вы создаёте сами
*/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(-1);
        nums.add(1);
        nums.add(15);
        nums.add(-6);
        nums.add(9);
        nums.add(5);
        nums.add(24);
        nums.add(-7);
        nums.add(2);

        ArrayList<Integer> newNums = new ArrayList<>();
        for (Integer n: nums){
            if(n>0 && n<10) {newNums.add(n);}
        }
        System.out.println(newNums);    // для проверки выведем новую коллекцию на экран
    }
}
