import java.util.Scanner;
import java.util.Random;

public class QuickSort {
    private static final Random RANDOM = new Random();

    private static <T extends Comparable <T>> int partition(T[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (less(a[lo], a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, lo, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static <T extends Comparable <T>> void sort(T[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static <T extends Comparable <T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public static <T extends Comparable <T>> void shuffle(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = QuickSort.uniform(i + 1);
            exch(a, i, r);
        }
    }

    public static int uniform(int upperBound) {
        return RANDOM.nextInt(upperBound);
    }

    private static <T extends Comparable <T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T> void exch(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int len = scanner.nextInt();

        Integer[] arr = new Integer[len];

        for (int i = 0; i < len; i++) {
            System.out.print("Enter element number " + (i + 1)+ ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Array before sorting: ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }

        // System.out.println("\nElements after Shuffling: ");
        // Quick.shuffle(arr);
        // for (int i = 0; i < len; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        System.out.println("\nArray after sorting: ");
        QuickSort.sort(arr);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        scanner.close();
    }
}