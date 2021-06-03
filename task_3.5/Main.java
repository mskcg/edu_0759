/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


public class Main {
    public static void main(String[] args) {
        int num[] = {4,2,6,2,65};

        show_array(num,0);
    }
    public static void show_array(int[] arr, int i) {
        if (i < arr.length) {
            System.out.print(arr[i] + " ");
            show_array(arr, i+1);
        }
    }
}
