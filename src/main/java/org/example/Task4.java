package org.example;

import java.util.*;
import java.math.BigInteger;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // Список всех возможных приростов
        ArrayList<Long> increases = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long num = arr[i];
            ArrayList<Integer> digits = new ArrayList<>();

            // Разбираем число на цифры
            while (num > 0) {
                digits.add((int)(num % 10));
                num /= 10;
            }

            // digits.get(0) = единицы, digits.get(digits.size()-1) = старший разряд
            for (int pos = 0; pos < digits.size(); pos++) {
                int d = digits.get(pos);
                if (d < 9) {
                    long increase = (9 - d) * (long)Math.pow(10, pos);
                    increases.add(increase);
                }
            }
        }

        // Сортируем по убыванию
        Collections.sort(increases, Collections.reverseOrder());

        // Берем k наибольших приростов
        long maxSumIncrease = 0;
        for (int i = 0; i < Math.min(k, increases.size()); i++) {
            maxSumIncrease += increases.get(i);
        }

        System.out.println(maxSumIncrease);
        sc.close();
    }
}

