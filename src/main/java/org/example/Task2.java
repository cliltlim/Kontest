package org.example;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); // количество людей / частей
        int cuts = 0;

        long pieces = 1;
        while (pieces < n) {
            pieces *= 2;
            cuts++;
        }

        System.out.println(cuts);

}}
