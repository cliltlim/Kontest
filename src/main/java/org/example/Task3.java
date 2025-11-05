package org.example;

import java.util.Scanner;

import java.util.*;

public class Task3 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int t = sc.nextInt();
            int[] floors = new int[n];
            for (int i = 0; i < n; i++) floors[i] = sc.nextInt();
            int leaveIdx = sc.nextInt() - 1;
            int x = floors[leaveIdx];

            int L = floors[0];
            int R = floors[n - 1];
            final int INF = 1_000_000_000;
            int best = INF;

            // Перебираем возможные стартовые этажи s,
            // которые позволяют достичь x за <= t минут
            int sMin = x - t;
            int sMax = x + t;
            for (int s = sMin; s <= sMax; s++) {
                // === Вариант A: s -> L -> R (идём к нижнему краю, потом до верхнего) ===
                int totalA = Math.abs(s - L) + (R - L);
                // время прихода к x на маршруте s->L->R:
                int timeA;
                // если x лежит на отрезке [s, L] (то есть мы проходим x по дороге к L)
                if ((s <= x && x <= L) || (L <= x && x <= s)) {
                    timeA = Math.abs(s - x);
                } else {
                    // сначала до L, затем от L до x
                    timeA = Math.abs(s - L) + Math.abs(x - L);
                }
                if (timeA <= t) best = Math.min(best, totalA);

                // === Вариант B: s -> R -> L (идём к верхнему краю, потом вниз) ===
                int totalB = Math.abs(s - R) + (R - L);
                int timeB;
                if ((s <= x && x <= R) || (R <= x && x <= s)) {
                    timeB = Math.abs(s - x);
                } else {
                    timeB = Math.abs(s - R) + Math.abs(x - R);
                }
                if (timeB <= t) best = Math.min(best, totalB);

                // === Вариант C: s -> x -> (обход оставшегося диапазона) ===
                // Если Катя сначала идёт к x (за |s-x| минут), а затем покрывает весь [L,R]
                // Минимальное дополнительное после x: (R-L) + min(x-L, R-x)
                // (то есть с x идём к ближайшему краю, потом до другого края)
                int timeC = Math.abs(s - x);
                if (timeC <= t) {
                    int afterX = (R - L) + Math.min(x - L, R - x);
                    int totalC = timeC + afterX;
                    // но totalC в терминах пройденных пролётов равен:
                    // |s-x| + (R-L) + min(x-L, R-x)
                    best = Math.min(best, totalC);
                }
            }

            System.out.println(best);
        }
    }