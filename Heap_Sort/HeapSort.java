import java.util.Scanner;

public class HeapSort {
    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length - 1;
        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N);
            sink(a, 1, --N);
        }
    }

    private static <T extends Comparable<T>> void sink(T[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j+1)) {
                j++;
            }
            if (!less(a, k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    private static <T extends Comparable<T>> boolean less(T[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }

    private static <T> void exch(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of heap: ");
        int sz = (scanner.nextInt() + 1);

        Integer[] heap = new Integer[sz];

        System.out.println("Enter elements of heap:");
        // heap[0] = null;
        for (int i = 1; i < sz; ++i) {
            heap[i] = scanner.nextInt();
        }

        System.out.print("Element before Sorting: ");
        for (int i = 0; i < sz; i++) {
            System.out.print(heap[i] + " ");
        }
        
        HeapSort.sort(heap);
        System.out.print("\nElements after Heap Sort: ");
        for (int i = 0; i < sz; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
        scanner.close();
    }
}