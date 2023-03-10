package com.coursemicron.fibonacci;

// O(2^n) -> Time complexity
// O(2^n) -> Space complexity
public class FibonacciRecursive {
    public static long fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(15));
    }
}
