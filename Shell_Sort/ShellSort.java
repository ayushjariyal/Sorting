import java.util.*;

public class ShellSort {
    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;

        int h = 1;
        while (h < N/3) {
            h = (3 * h + 1);
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h = h / 3;
        }
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T> void exch(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please provide size of array: ");
        int n = scanner.nextInt();

        Integer[] array = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter  element number " + (i+1) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Array before Sorting:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        ShellSort.sort(array);

        System.out.println("\nArray after Sorting:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        scanner.close();
     }
}