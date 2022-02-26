package org.datastructures.arrays.challenges;

import java.util.HashMap;
import java.util.Map;

/** Problem Statement
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> differenceMap = new HashMap<>();
        int[] result = new int[2];

        for (int index = 0; index < nums.length; index++) {

            if (differenceMap.containsKey(nums[index])) {

                // System.out.println(differenceMap.get(nums[index]));

                result[0] = differenceMap.get(nums[index]);
                result[1] = index;

                return result;
            }


            int difference = target - nums[index];
            differenceMap.put(difference, index);

        }

        return result;


    }
}
