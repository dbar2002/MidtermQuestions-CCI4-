// 10.3
// Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown number of times,
// write code to find an element in the array.
// You may assume that the array was originally sorted in increasing order.


public class SearchInRotatedArray {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check which side of the mid-point is sorted
            if (nums[left] <= nums[mid]) {
                // Left side is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // Target is on the left side
                    right = mid - 1;
                } else {
                    // Target is on the right side
                    left = mid + 1;
                }
            } else {
                // Right side is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // Target is on the right side
                    left = mid + 1;
                } else {
                    // Target is on the left side
                    right = mid - 1;
                }
            }
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(nums, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}
