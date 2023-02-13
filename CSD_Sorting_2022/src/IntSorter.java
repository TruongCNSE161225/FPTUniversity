
import java.util.LinkedList;

public class IntSorter {

    public static void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static int getMinIndex(int a[], int first, int last) {
        int minIndex = first;
        for (int i = first + 1; i <= last; i++) {
            if (a[minIndex] > a[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void selectionSort(int a[], int n) {
        int minIndex;
        for (int i = 0; i < n - 1; i++) {
            minIndex = getMinIndex(a, i, n - 1);
            swap(a, minIndex, i);
        }
    }

    public static void insertionSort(int a[], int n) {
        int i, j, tmp;
        for (i = 1; i < n; i++) {
            tmp = a[i];
            j = i - 1;
            while (j >= 0 && a[j] > tmp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
        }
    }

    public static void bubbleSort(int a[], int n) {
        int i, j;
        for (i = 0; i < n - 1; i++) {
            for (j = n - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    public static void quickSort(int a[], int first, int last) {
        int pivoteIndex = first;
        int pivote = a[pivoteIndex];
        int lower = first + 1, upper = last;
        while (lower <= upper) {
            while (lower <= upper && a[lower] < pivote) {
                lower++;
            }
            while (lower <= upper && a[upper] >= pivote) {
                upper--;
            }
            if (lower < upper) {
                swap(a, lower++, upper--);
            } else {
                lower++;
            }
        }
        swap(a, upper, first);
        if (first < upper - 1) {
            quickSort(a, first, upper - 1);
        }
        if (upper + 1 < last) {
            quickSort(a, upper + 1, last);
        }
    }

    public static void quickSort(int a[], int n) {
        quickSort(a, 0, n - 1);
    }

    static int[] temp;

    private static void merge(int[] a, int first, int last) {
        int mid = (first + last) / 2;
        int i = first;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= last) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= last) {
            temp[k++] = a[j++];
        }
        for (k = 0, i = first; i <= last; a[i++] = temp[k++]);
    }

    private static void mergeSort(int[] a, int first, int last) {
        int mid = (first + last) / 2;
        if (first < mid) {
            mergeSort(a, first, mid);
        }
        if (mid + 1 < last) {
            mergeSort(a, mid + 1, last);
        }
        merge(a, first, last);
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        temp = new int[n];
        mergeSort(a, 0, n - 1);
    }

    public static void moveDown(int[] a, int first, int last) {
        int largest = 2 * first + 1;
        while (largest <= last) {
            if (largest < last && a[largest] < a[largest + 1]) {
                largest++;
            }
            if (a[first] < a[largest]) {
                swap(a, first, largest);
                first = largest;
                largest = 2 * first + 1;
            } else {
                largest = last + 1;
            }
        }
    }

    public static void heapSort(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; --i) {
            moveDown(a, i, n - 1);
        }
        for (int i = n - 1; i >= 1; --i) {
            swap(a, 0, i);
            moveDown(a, 0, i - 1);
        }
    }

    public static int countDigits(int n) {
        return (int) (Math.log10(n)) + 1;
    }

    public static int maxAbsolute(int a[], int n) {
        int result = Integer.MIN_VALUE;
        for (int x : a) {
            if (x < 0) {
                x = -x;
            }
            if (result < x) {
                result = x;
            }
        }
        return result;
    }

    public static void radixSort(int a[], int n) {
        int RADIX = 10;
        int longest = maxAbsolute(a, n);
        int digits = countDigits(longest);
        int d, j, k, factor;
        LinkedList<Integer>[] queues = new LinkedList[RADIX];
        for (d = 0; d < RADIX; d++) {
            queues[d] = new LinkedList();
        }
        factor = 1;
        int queueIndex;
        for (d = 1; d <= digits; d++) {
            for (j = 0; j < n; j++) {
                queueIndex = (a[j] / factor) % RADIX;
                queues[queueIndex].addLast(a[j]);
            }
            k = 0;
            for (j = 0; j < RADIX; j++) {
                while (!queues[j].isEmpty()) {
                    a[k++] = queues[j].removeFirst();
                }
            }
            factor *= RADIX;
        }
    }
}
