package org.example;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

//        int[] arr = createArray();
//        int[] arr1 = Arrays.copyOf(arr, 100_000);
//        int[] arr2 = Arrays.copyOf(arr, 100_000);
//        int[] arr3 = Arrays.copyOf(arr, 100_000);
//        long start = System.currentTimeMillis();
//        sortBubble(arr1);
//        long timeBubble = System.currentTimeMillis() - start;
//        System.out.println("timeBubble " + timeBubble);
//        start = System.currentTimeMillis();
//        sortSelection(arr2);
//        long timeSelection = System.currentTimeMillis() - start;
//        System.out.println("timeSelection " + timeSelection);
//        start = System.currentTimeMillis();
//        sortInsertion(arr3);
//        long timeInsertion = System.currentTimeMillis() - start;
//        System.out.println("timeInsertion " + timeInsertion);


    }
    private static int[] createArray() {
        int[] arr = new int[100_000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

}