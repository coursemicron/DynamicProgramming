package com.coursemicron.canconstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// O(n* m^2) -> Time Complexity
// O(m^2) -> Space complexity
public class CanConstructDP {
    public static boolean canConstruct(String targetString, List<String> wordBank, Map<String, Boolean> memory){
        if(memory.containsKey(targetString))return memory.get(targetString);
        if(targetString.equals(""))return true;

        for(String word: wordBank){
            if(targetString.startsWith(word)){
                String suffix = targetString.substring(word.length());
                if(canConstruct(suffix, wordBank, memory)){
                    memory.put(suffix, true);
                    return true;
                }
            }
        }
        memory.put(targetString, false);
        return false;
    }

    public static void main(String[] args) {
        List<String> wordBank = new ArrayList<>();
        wordBank.add("abc");
        wordBank.add("d");
        wordBank.add("def");
        System.out.println(canConstruct("abcdef", wordBank, new HashMap<>()));
        System.out.println(canConstruct("ab", wordBank, new HashMap<>()));
        System.out.println(canConstruct("abcd", wordBank, new HashMap<>()));
    }
}
