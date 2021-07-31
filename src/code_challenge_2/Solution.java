/*
 * © 2021 tienhuynh.lttn
 * All rights reserved!
 * For more information, please contact via my email: tien.huynhlt.tn@gmail.com
 */
package code_challenge_2;

/**
 *
 * @author Huỳnh Lê Thủy Tiên <tien.huynhlt.tn@gmail.com>
 */

/*
 * Maximum Length of Repeated Subarray
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 * Reference source: https://www.tutorialcup.com/interview/array/maximum-length-of-repeated-subarray.htm
 */

class Solution {
    public static int findLength(int[] nums1, int[] nums2) {
        int output = 0;
        int val[][] = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; --i)
        {
            for (int j = nums2.length - 1; j >= 0; --j)
            {
                if (nums1[i] == nums2[j])
                {
                    val[i][j] = val[i+1][j+1] + 1;
                    if(output < val[i][j])
                        output = val[i][j];
                }
            }
        }
        return output;    
    }
    
    public static void main(String []args)
    {
        int a[]= {1,2,3,2,1};
        int b[]= {3,2,1,4,7};
        System.out.println("Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]");
        System.out.println("Output: " + findLength(a,b));
    }
}

