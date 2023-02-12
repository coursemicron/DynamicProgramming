package com.coursemicron.cansum;

import java.util.HashMap;
import java.util.Map;

public class CanSumDP {
    public static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memory) {
        if (memory.containsKey(targetSum)) return memory.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int num : numbers) {
            if (canSum(targetSum - num, numbers, memory)) {
                memory.put(targetSum, true);
                return true;
            }
        }
        memory.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4};
        System.out.println(canSum(11, numbers, new HashMap<>()));
        System.out.println(canSum(2, numbers, new HashMap<>()));
        System.out.println(canSum(6, numbers, new HashMap<>()));
    }
}
