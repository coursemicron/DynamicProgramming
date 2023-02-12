package com.coursemicron.shortedsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortedSumDP {
    public static int[] shortestSum(int targetSum, int[] numbers, Map<Integer, int[]> memory){
        if(memory.containsKey(targetSum))return memory.get(targetSum);
        if(targetSum == 0)return new int[]{};
        if(targetSum < 0) return null;

        int[] shortestSumArr = null;
        for(int num: numbers){
            int remainder = targetSum - num;
            int[] remainderCombination = shortestSum(remainder, numbers, memory);
            if(remainderCombination != null){
                remainderCombination = addElementToArr(num, remainderCombination);
                if(shortestSumArr == null || remainderCombination.length<shortestSumArr.length)shortestSumArr=remainderCombination;

            }

        }
        memory.put(targetSum, shortestSumArr);
        return shortestSumArr;
    }
    public static int[] addElementToArr(int num, int[] arr){
        int[] result = new int[arr.length+1];
        int index=0;
        for(int number:arr){
            result[index]=number;index++;
        }
        result[index] = num;
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {5,3,4,7};
        System.out.println(Arrays.toString(shortestSum(7, numbers, new HashMap<>())));
        System.out.println(Arrays.toString(shortestSum(11, numbers, new HashMap<>())));

    }
}
