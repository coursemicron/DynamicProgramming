package com.coursemicron.gridtraveller;

import java.util.HashMap;
import java.util.Map;

// O(m*n) -> Time complexity
// O(m+n) -> Space complexity
public class GridTravellerDP {
    public static long gridTraveller(int m, int n, Map<String, Long> memory) {
        String key = m + "," + n;
        if (memory.containsKey(key)) return memory.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        memory.put(key, gridTraveller(m - 1, n, memory) + gridTraveller(m, n - 1, memory));
        return memory.get(key);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveller(2, 3, new HashMap<>())); // 3
        System.out.println(gridTraveller(3, 3, new HashMap<>())); // 6
        System.out.println(gridTraveller(5, 5, new HashMap<>())); // 70
        System.out.println(gridTraveller(8, 8, new HashMap<>())); // 3432
        System.out.println(gridTraveller(18, 18, new HashMap<>())); // 2333606220
    }
}
