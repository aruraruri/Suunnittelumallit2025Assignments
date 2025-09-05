package Strategy;

public class QuickSort implements SortingStrategy{
    @Override
    public int[] sortInts(int[] ints) {
        int n = ints.length;
        quickSort(ints, 0, n - 1);
        return ints;
    }

    // algo from:
    // https://www.geeksforgeeks.org/dsa/quick-sort-algorithm/

    // swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // partition function
    static int partition(int[] arr, int low, int high) {

        // choose the pivot
        int pivot = arr[high];

        // index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // recursion calls for smaller elements
            // and greater or equals elements
            // Recursively sort the smaller partition first
            // this part was worked on by Deepseek, needed help to avoid stack overflow quicksorting small arrays
            // G4G algo crashed on 30 ints
            if (pi - low < high - pi) {
                quickSort(arr, low, pi - 1);
            } else {
                quickSort(arr, pi + 1, high);
            }
        }
    }

}
