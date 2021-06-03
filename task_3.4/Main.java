/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если их сумма больше 10 - пусть функция вернет true, а если нет - false.

*/


public class Main {
    public static void main(String[] args) {
        int x = 3;
        int y = 7;

        System.out.println(compare_sum(x, y));
    }
    public static boolean compare_sum(int a, int b) {
        if (a+b > 10)
            return true;
        else
            return false;
    }
}
