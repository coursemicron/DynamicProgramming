package com.coursemicron.allconstruct;

import java.util.ArrayList;
import java.util.List;

public class AllConstructRecursive {
    public static List<List<String>> allConstruct(String targetString, List<String> wordBank){
        if(targetString.equals(""))return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        for(String word: wordBank){
            if(targetString.startsWith(word)){
                String suffix = targetString.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix,wordBank);
                List<List<String>> targetWays = addWordToEachList(word, suffixWays);
                result.addAll(targetWays);
            }
        }
        return result;
    }

    private static List<List<String>> addWordToEachList(String word, List<List<String>> suffixWays) {
        List<List<String>> combinedList = new ArrayList<>();
        for (List<String> suffixWay: suffixWays){
            suffixWay.add(0,word);
            combinedList.add(suffixWay);
        }
        return combinedList;
    }

    public static void main(String[] args) {
        List<String> wordBank = new ArrayList<>();
        wordBank.add("abc");
        wordBank.add("d");
        wordBank.add("def");
        System.out.println(allConstruct("abcdef", wordBank));
        System.out.println(allConstruct("ab", wordBank));
        System.out.println(allConstruct("abcd", wordBank));
    }
}
