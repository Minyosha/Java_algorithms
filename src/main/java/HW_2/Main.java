package HW_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество символов в массиве:");
        int size = in.nextInt();
        int arr[];
        arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }

        System.out.println("Сгенерирован массив:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }

        System.out.println();
        System.out.println("Применение пирамидальной сортировки:");

        long start = System.nanoTime();

        heapSort(arr);

        long finish = System.nanoTime();
        long elapsed = finish - start;

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }

        System.out.println();
        System.out.println("На сортировку потрачено времени, нс: " + elapsed);
    }


    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i, n);

        for (int i = n - 1; i >= 0; i--) {

            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }

    }

    private static void heapify(int[] arr, int i, int n) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (i != largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, n);
        }
    }
}

