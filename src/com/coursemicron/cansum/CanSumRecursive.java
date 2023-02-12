package com.coursemicron.cansum;

// O(n^m) --> Time complexity
// O(m+n) -> Space Complexity
public class CanSumRecursive {
    public static boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int num : numbers) {
            if (canSum(targetSum - num, numbers)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4};
        System.out.println(canSum(11, numbers));
        System.out.println(canSum(2, numbers));
        System.out.println(canSum(6, numbers));
    }
}
