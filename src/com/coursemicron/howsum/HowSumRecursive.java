package com.coursemicron.howsum;

import java.util.ArrayList;
import java.util.Arrays;

// O(n^m * m) -> Time complexity
// O(m)
public class HowSumRecursive {
    public static int[] howSum(int targetSum, int[] numbers){
        if(targetSum == 0)return new int[]{};
        if(targetSum < 0) return null;

        for(int num: numbers){
            int remainder = targetSum - num;
            int[] remainderResult = howSum(remainder, numbers);
            if(remainderResult != null){
                return addElementToArr(num, remainderResult);
            }


        }
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
        System.out.println(Arrays.toString(howSum(7, numbers)));
        System.out.println(Arrays.toString(howSum(5, numbers)));

    }
}
