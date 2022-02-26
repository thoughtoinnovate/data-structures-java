package org.datastructures.arrays.challenges;

/***
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSubArray {


    /**
     * kadane's algorithm
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int maxSofar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < nums.length; i++) {
            maxEndingHere = maxEndingHere + nums[i];
            if (maxEndingHere > maxSofar) {
                maxSofar = maxEndingHere;
            } if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSofar;

    }

    public static void main(String[] args) {
        int[] myArray=new int[]{-2,-3,-1};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(myArray));
    }
}
