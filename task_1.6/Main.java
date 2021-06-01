/*
Пользователь вводит число, необходимо увеличить это число на 15% и вывести результат на экран
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ваш код
        System.out.print("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(num*1.15f);
    }
}
