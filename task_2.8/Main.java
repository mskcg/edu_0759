/*
Задание: Дан массив с элементами [2, 3, 4, 5]. С помощью цикла for найдите произведение элементов этого массива.
*/

public class Main {
    public static void main(String[] args) {
        int[] array = {2,3,4,5};
        int mult = array[0];
        for (int i = 1; i < 4; i++) {
            mult *= array[i];
        }
        System.out.println(mult);
    }
}
