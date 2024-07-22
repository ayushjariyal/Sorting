import java.util.*;

public class Selection {
    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
                exch(a, i, min);
            }
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

        System.out.println("Please provide the size of array: ");
        int n = scanner.nextInt();

        Double[] array = new Double[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextDouble();
        }

        Selection.sort(array);

        for (Double value : array) {
            System.out.println(value);
        }
        scanner.close();
    }
}