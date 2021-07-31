/*
 * © 2021 tienhuynh.lttn
 * All rights reserved!
 * For more information, please contact via my email: tien.huynhlt.tn@gmail.com
 */
package code_challenge_3;

/**
 *
 * @author Huỳnh Lê Thủy Tiên <tien.huynhlt.tn@gmail.com>
 */
public class Solution {
    public static int findPeakElement(int[] nums) {
        // First or last element is peak element
        int n = nums.length;
        if (n == 1)
          return 0;
        if (nums[0] >= nums[1])
            return 0;
        if (nums[n - 1] >= nums[n - 2])
            return n - 1;

        // Check for every other element
        for(int i = 1; i < n - 1; i++)
        {
            // Check if the neighbors are smaller
            if (nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1])
                return i;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int nums1[] = {1,2,3,1};
        int nums2[] = {1,2,1,3,5,6,4};

        System.out.print("Input: nums1 = [1,2,3,1]");
        System.out.println(" Output: " + findPeakElement(nums1));
    
        System.out.print("Input: nums2 = [1,2,1,3,5,6,4]");
        System.out.println(" Output: " + findPeakElement(nums2));
    }
}
