package com.ledgerline.algorithms;

public final class MaximumSubarray {

    public static int maxSubarraySum(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values must not be null or empty");
        }
        int currentSum = values[0];
        int bestSum = values[0];
        for (int i = 1; i < values.length; i++) {
            currentSum = Math.max(values[i], currentSum + values[i]);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }
}
