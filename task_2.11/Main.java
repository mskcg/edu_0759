/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {
        int [] nums = {5,2,7,8,1,9,6,3};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > 10) {
                System.out.println("нужно сложить первых элементов: " + (i+1));
                return;
            }
        }
        System.out.println("сумма всех элементов не больше 10");
    }
}
