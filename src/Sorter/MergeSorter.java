package Sorter;

public class MergeSorter extends AbstractSorter{

    public void sort(Integer[] values){
        this.MergeSort(values, 0, values.length - 1);
    }
    private void MergeSort(Integer[] values, int left, int right){
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            this.MergeSort(values, left, mid);
            this.MergeSort(values, mid + 1, right);

            // Merge the sorted halves
            merge(values, left, mid, right);
        }
    }

    private void merge(Integer[] values, int left, int mid, int right){
        // Find sizes of two sub-arrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = values[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = values[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                values[k] = L[i];
                i++;
            }
            else {
                values[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            values[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            values[k] = R[j];
            j++;
            k++;
        }
    }
}
