/* 
ВНИМАНИЕ! ДЛЯ РЕШЕНИЯ ЗАДАЧИ НЕОБХОДИМО ПРОСМОТРЕТЬ УРОК №4 https://www.youtube.com/watch?v=WmZ6kVTlWtg&list=PLOep0pi-UBExIxCNegkvCrBuDh0TE7Ihq&index=4
Программа запрашивает у пользователя значение в градусах Цельсия. Программа должена переводить температуру и выводить на экран
значение в градусах Фаренгейта.
Температура по Цельсию TC и температура по Фаренгейту TF связаны следующим соотношением:
TF = (9 / 5) * TC + 32
Пример:
на вход подается значение 41.
Пример вывода:
105.8 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите значение в градусах Цельсия: ");
        Scanner scan = new Scanner(System.in);
        int t_celc = scan.nextInt();
        double t_far = (9 / 5) * t_celc + 32;
        System.out.println("это " + t_far + " градусов по Фаренгейту.");
    }
}
