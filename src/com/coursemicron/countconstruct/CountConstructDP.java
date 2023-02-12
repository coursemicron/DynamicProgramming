package com.coursemicron.countconstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstructDP {
    public static int countConstruct(String targetString, List<String> wordBank, Map<String,Integer> memory){
        if(memory.containsKey(targetString))return memory.get(targetString);
        if(targetString.equals("")) return 1;
        int count = 0;
        for(String word:wordBank){
            if(targetString.startsWith(word)){
                String suffix = targetString.substring(word.length());
                count += countConstruct(suffix, wordBank, memory);
            }
        }
        memory.put(targetString, count);
        return count;
    }
    public static void main(String[] args) {
        List<String> wordBank = new ArrayList<>();
        wordBank.add("abc");
        wordBank.add("d");
        wordBank.add("def");
        System.out.println(countConstruct("abcdef", wordBank, new HashMap<>()));
        System.out.println(countConstruct("ab", wordBank, new HashMap<>()));
        System.out.println(countConstruct("abcd", wordBank, new HashMap<>()));
    }
}
