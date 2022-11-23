package com.example.comp3111_project.Algorithms;



/* Java program for Merge Sort */
public class MergeSort {
	
	// SHOULD NOT BE CALLED --> private
    /* DO: merge 1st & 2nd parts, where 1st part: arr[l..m] & 2nd part: arr[m+1..r] */
    private static void merge(SortingEntity arr[], int l, int m, int r, boolean ascending)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        SortingEntity L[] = new SortingEntity[n1];
        SortingEntity R[] = new SortingEntity[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
        	if (ascending) {
	            if (L[i].getData() <= R[j].getData()) {
	                arr[k] = L[i];
	                i++;
	            } else {
	                arr[k] = R[j];
	                j++;
	            }
        	} else {
        		if (L[i].getData() >= R[j].getData()) {
	                arr[k] = L[i];
	                i++;
	            } else {
	                arr[k] = R[j];
	                j++;
	            }
        	}
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    /**
	 * sort(..) method sorts SortingEntity array in ascending or descending order
	 * of the value of the attribute {@code data} in each element
	 * @param a SortingEntity array, arr[]
	 * @param an integer for the smallest index, l
	 * @param an integer for the largest index, r
	 * @param a boolean for specifying how {@code arr} is sorted, ascending 
	 * @return none
	 */
    // MAIN FUNCTION: CAN BE CALLED --> public
    /* DO: sort arr[l..r] */
    public static void sort(SortingEntity arr[], int l, int r, boolean ascending)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sort(arr, l, m, ascending);
            sort(arr, m + 1, r, ascending);
 
            // Merge the sorted halves
            merge(arr, l, m, r, ascending);
        }
    }
 
    // UTILITY FUNC: CAN BE CALLED FOR DEBUGGING
    /* DO: print array of size n, useful in debugging */
    static void printArray(SortingEntity arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i].getData() + " ");
        System.out.println();
    }
}
