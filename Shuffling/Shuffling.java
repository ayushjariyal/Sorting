import java.util.Scanner;
import java.util.Random;

public class Shuffling {
    private static final Random RANDOM = new Random();

    public static <T extends Comparable<T>> void shuffle(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = Shuffling.uniform(i + 1);
            exch(a, i, r);
        }
    }

    public static int uniform(int upperBound) {
        return RANDOM.nextInt(upperBound);
    }

    public static <T> void exch(T[] a, int i, int j) {
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
            System.out.print("Enter element number " + (i+1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Array without Shuffling: ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\nArray after Shuffling: ");

        Shuffling.shuffle(arr);

        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        scanner.close();
    }
}