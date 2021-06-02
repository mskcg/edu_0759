/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму вклада: ");
        double deposit = scanner.nextInt();
        System.out.print("Введите процент начисления: ");
        double percentage = scanner.nextInt();

        for (int i = 1; i < 6; i++) {
            System.out.print("размер вклада после " + i + " года: ");
            System.out.format("%-10.1f%n", deposit += deposit*(percentage/100));
        }
    }
}
