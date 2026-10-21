package com.ledgerline.algorithms;

public final class BinarySearch {

    public static int indexOf(int[] sortedValues, int target) {
        if (sortedValues == null) {
            return -1;
        }
        int low = 0;
        int high = sortedValues.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int value = sortedValues[middle];
            if (value == target) {
                return middle;
            } else if (value < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
