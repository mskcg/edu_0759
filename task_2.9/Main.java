/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,6,3,2,9,1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 5) {
                System.out.println("да");
                return;
            }
        }
        System.out.println("нет");
    }
}
