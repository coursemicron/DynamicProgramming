package com.coursemicron.canconstruct;

import java.util.ArrayList;
import java.util.List;

// O(n^m*m) -> Time complexity
// O(m^2) -> Space complexity
public class CanConstructStringRecursive {
    public static boolean canConstruct(String targetString, List<String> wordBank){
        if(targetString.equals(""))return true;

        for(String word: wordBank){
            if(targetString.startsWith(word)){
                if(canConstruct(targetString.substring(word.length()), wordBank)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> wordBank = new ArrayList<>();
        wordBank.add("abc");
        wordBank.add("d");
        wordBank.add("def");
        System.out.println(canConstruct("abcdef", wordBank));
        System.out.println(canConstruct("ab", wordBank));
        System.out.println(canConstruct("abcd", wordBank));
    }
}
