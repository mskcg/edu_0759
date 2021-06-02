/*
ВНИМАНИЕ эта задача для ДЗ и не является обязательной.
Задание: 1. Создай массив чисел.
2. Добавь в массив 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int array_length = 10;
        int [] nums = new int [array_length];
        // заполнение массива с клавиатуры
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array_length; i++) {
            nums[i] = scanner.nextInt();
        }
        // найдём наибольшую длину повторяющейся последовательности чисел в массиве
        int length_max = 1;
        int length_curr = 1;
        for (int i = 1; i < array_length; i++) {
            if (nums[i] == nums[i-1]) {
                length_curr++;
                if (length_max < length_curr)
                    length_max = length_curr;
            }
            else
                length_curr = 1;
        }
        // отображение массива для контроля
        for (int j = 0; j < array_length; j++) {
            System.out.print(nums[j] + " ");
        }
        System.out.println();
        System.out.println(length_max);
    }
}
