package com.coursemicron.shortedsum;

import java.util.Arrays;
import java.util.HashMap;

public class ShortestSumRecursive {
    public static int[] shortestSum(int targetSum, int[] numbers){
        if(targetSum == 0)return new int[]{};
        if(targetSum < 0) return null;

        int[] shortestSumArr = null;
        for(int num: numbers){
            int remainder = targetSum - num;
            int[] remainderCombination = shortestSum(remainder, numbers);
            if(remainderCombination != null){
                remainderCombination = addElementToArr(num, remainderCombination);
                if(shortestSumArr == null || remainderCombination.length<shortestSumArr.length)shortestSumArr=remainderCombination;

            }

        }
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
        System.out.println(Arrays.toString(shortestSum(7, numbers)));
        System.out.println(Arrays.toString(shortestSum(11, numbers)));

    }
}
