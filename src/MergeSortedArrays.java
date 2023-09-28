// 10.1
// Sorted Merge: You are given two sorted arrays, A and B,
// where A has a large enough buffer at the end to hold B.
// Write a method to merge B into A in sorted order. in java

public class MergeSortedArrays {
    public static void merge(int[] A, int m, int[] B, int n) {
        int indexA = m - 1; // Index of the last element in array A
        int indexB = n - 1; // Index of the last element in array B
        int mergedIndex = m + n - 1; // Index of the last position in the merged array A

        // Merge elements from the end of both arrays
        while (indexA >= 0 && indexB >= 0) {
            if (A[indexA] > B[indexB]) {
                A[mergedIndex] = A[indexA];
                indexA--;
            } else {
                A[mergedIndex] = B[indexB];
                indexB--;
            }
            mergedIndex--;
        }

        // If there are remaining elements in array B, copy them to A
        while (indexB >= 0) {
            A[mergedIndex] = B[indexB];
            indexB--;
            mergedIndex--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[10]; // A has enough space to hold B
        int[] B = {2, 4, 6, 8, 10};
        int m = 5; // Number of elements in A
        int n = 5; // Number of elements in B

        // Populate A with initial elements (e.g., [1, 3, 5, 7, 9, _, _, _, _, _])
        for (int i = 0; i < m; i++) {
            A[i] = 2 * i + 1;
        }

        merge(A, m, B, n);

        // Print the merged array A
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}
