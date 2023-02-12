package com.coursemicron.countconstruct;

import java.util.ArrayList;
import java.util.List;

public class CountConstructRecursive {
    public static int countConstruct(String targetString, List<String> wordBank){
        if(targetString.equals("")) return 1;
        int count = 0;
        for(String word:wordBank){
            if(targetString.startsWith(word)){
                String suffix = targetString.substring(word.length());
                count += countConstruct(suffix, wordBank);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        List<String> wordBank = new ArrayList<>();
        wordBank.add("abc");
        wordBank.add("d");
        wordBank.add("def");
        System.out.println(countConstruct("abcdef", wordBank));
        System.out.println(countConstruct("ab", wordBank));
        System.out.println(countConstruct("abcd", wordBank));
    }
}
