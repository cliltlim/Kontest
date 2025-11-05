package org.example;
import java.util.Scanner;

public class Task1 {

    public static int kostya_mobile() {
        Scanner sc = new Scanner(System.in);
        int rate = sc.nextInt();          // стоимость тарифа в месяц
        int rate_megabyte = sc.nextInt(); // количество мегабайт в тарифе
        int overflow = sc.nextInt();      // стоимость каждого мегабайта после лимита
        int plan = sc.nextInt();          // запланированное количество мегабайт

        int sum = 0;
        if (rate >= 0 && rate_megabyte >=0 && overflow>= 0 && plan >=0){
        if (plan <= rate_megabyte) {
            sum = rate;
        } else {
            sum = rate + (plan - rate_megabyte) * overflow;
        }


    }return sum;
    }

    public static void main(String[] args) {
        System.out.println(Task1.kostya_mobile());
    }
}
