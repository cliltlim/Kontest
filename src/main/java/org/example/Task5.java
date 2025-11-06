package org.example;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();

        long count = 0;


        for (int digit = 1; digit <= 9; digit++) {
            long num = digit; // 1, 2, ..., 9
            while (num <= r) {
                if (num >= l) {
                    count++;
                }
                num = num * 10 + digit;
            }
        }

        System.out.println(count);
    }
}

