package org.example;

import java.util.Scanner;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] floors = new int[n];
        for (int i = 0; i < n; i++) {
            floors[i] = sc.nextInt();
        }
        int leavingIndex = sc.nextInt() - 1; // индекс уходящего
        int leaveFloor = floors[leavingIndex];

        int minFloor = floors[0];
        int maxFloor = floors[n - 1];
        int best = Integer.MAX_VALUE;

        // вариант 1: сначала вниз, потом вверх
        int dist1 = (leaveFloor - minFloor <= t) ? (maxFloor - minFloor) + (leaveFloor - minFloor) : Integer.MAX_VALUE;

        // вариант 2: сначала вверх, потом вниз
        int dist2 = (maxFloor - leaveFloor <= t) ? (maxFloor - minFloor) + (maxFloor - leaveFloor) : Integer.MAX_VALUE;

        // но это всё ещё не всегда достаточно — рассмотрим все возможные старты
        for (int start : floors) {
            for (int end : floors) {
                int low = Math.min(start, end);
                int high = Math.max(start, end);
                int total = high - low; // пройти весь диапазон
                if (Math.abs(start - leaveFloor) <= t || Math.abs(low - leaveFloor) <= t || Math.abs(high - leaveFloor) <= t) {
                    best = Math.min(best, total + Math.min(Math.abs(start - leaveFloor), Math.abs(end - leaveFloor)));
                }
            }
        }

        System.out.println(Math.min(best, Math.min(dist1, dist2)));
    }
}

