/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/


public class Main {
    public static void main(String[] args) {
        int x = 3;
        int y = 7;

        System.out.println(compare_two(x,y));
    }

    public static boolean compare_two (int a, int b) {
        if (a==b)
            return true;
        else
            return false;
    }
}
