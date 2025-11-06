package org.example;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        boolean found = false;
        // Перебираем все пары
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(heights, i, j);
                if (isCorrect(heights)) {
                    System.out.println((i + 1) + " " + (j + 1));
                    found = true;
                    break;
                }
                swap(heights, i, j); // возвращаем обратно
            }
            if (found) break;
        }

        if (!found) System.out.println("-1 -1");

        sc.close();
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static boolean isCorrect(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean shouldBeEven = ((i + 1) % 2 == 0);
            boolean isEven = (arr[i] % 2 == 0);
            if (shouldBeEven != isEven) return false;
        }
        return true;
    }
}



