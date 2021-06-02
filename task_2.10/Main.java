/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int [] nums = {5,2,7,8,4,3,9,1};
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                System.out.println("да");
                return;
            }
        }
        System.out.println("нет");
    }
}
