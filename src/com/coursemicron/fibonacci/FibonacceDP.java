package com.coursemicron.fibonacci;

import java.util.HashMap;
import java.util.Map;

// O(n) -> Time complexity
// O(n) -> Space complexity
public class FibonacceDP {
    public static long fib(int n, Map<Integer, Long> memory) {
        if (memory.containsKey(n)) return memory.get(n);
        if (n <= 2) return 1;
        memory.put(n, fib(n - 1, memory) + fib(n - 2, memory));
        return memory.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fib(2, new HashMap<>()));
        System.out.println(fib(50, new HashMap<>()));
    }
}
