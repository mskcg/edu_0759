/* Задача наполнить корабельный бассейн. Нужно посчитать, сколько литров воды нужно для заполнения бассейна до бортов.
Известно, что бассейн имеет линейные размеры a × b × c, заданные в метрах.
Эти размеры передаются запрашиваются у пользователя. Прграмма должена вывести на экран количество литров воды,
которое нужно для наполнения бассейна.
Пример:
Пользователь даёт числа 25, 5, 2.
Пример вывода:
250000 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("длина бассейна: ");
        int x = scanner.nextInt();
        System.out.print("ширина бассейна: ");
        int y = scanner.nextInt();
        System.out.print("глубина бассейна: ");
        int z = scanner.nextInt();

        System.out.println("Потребуется литров воды: " + x*y*z*1000);
    }
}
