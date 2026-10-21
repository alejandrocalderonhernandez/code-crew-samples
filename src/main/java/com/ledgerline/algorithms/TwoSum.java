package com.ledgerline.algorithms;

import java.util.HashMap;

public final class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer previousIndex = seen.get(complement);
            if (previousIndex != null) {
                return new int[] {previousIndex, i};
            }
            seen.put(nums[i], i);
        }
        return new int[0];
    }
}
