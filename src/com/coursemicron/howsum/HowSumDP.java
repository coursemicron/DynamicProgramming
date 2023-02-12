package com.coursemicron.howsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// O(n*m*m)/O(n*m^2 -> Time complexity
// O(m^2) -> Space complexity

public class HowSumDP {
    public static int[] howSum(int targetSum, int[] numbers, Map<Integer, int[]> memory){
        if(memory.containsKey(targetSum))return memory.get(targetSum);
        if(targetSum == 0)return new int[]{};
        if(targetSum < 0) return null;

        for(int num: numbers){
            int remainder = targetSum - num;
            int[] remainderResult = howSum(remainder, numbers,memory);
            if(remainderResult != null){
                int[] newArr = addElementToArr(num, remainderResult);
                memory.put(targetSum,newArr);
                return memory.get(targetSum);
            }


        }
        memory.put(targetSum,null);
        return null;
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
        System.out.println(Arrays.toString(howSum(7, numbers, new HashMap<>())));
        System.out.println(Arrays.toString(howSum(5, numbers, new HashMap<>())));

    }
}
