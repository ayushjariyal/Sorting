import java.util.Scanner;

public class BUMergeSort {
    public static <T extends Comparable<T>> void merge(T[] a, T[] aux, int lo, int mid, int hi ) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        for (int k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            }
            else if (j > hi) {
                a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }

        assert isSorted(a, lo, hi);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        T[] aux = (T[]) new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo+sz+sz-1, N - 1));
            }
        }
    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a, int lo, int hi) {
        for (int i = 0; i < hi; i++) {
            if (a[i].compareTo(a[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int len = scanner.nextInt();

        Integer[] arr = new Integer[len];

        for (int i = 0; i < len; i++) {
            System.out.print("Enter element number " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Array before sorting:");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }

        BUMergeSort.sort(arr);

        System.out.println("\nArray after mergeSort:");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        scanner.close();
    }
}