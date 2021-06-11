/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        while (true) {
            String family = scanner.nextLine();
            if (family.isEmpty()) {
                break;
            }

            list.add(family);
        }

        // Прочитать название города
        System.out.print("Введите город: ");
        String city = scanner.nextLine();
        int cityIndex = list.indexOf(city);
        if(cityIndex != -1) {
            String familyName = list.get(cityIndex+1);
            System.out.println(familyName);
        }else {System.out.println("Город не найден!");}
    }
}
