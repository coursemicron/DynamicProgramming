package com.coursemicron.gridtraveller;

// O(2^m+n) -> Time complexity
// O(m+n) -> Space complexity
public class GridTravellerRecursive {
    public static long gridTraveller(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        return gridTraveller(m - 1, n) + gridTraveller(m, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveller(2, 3)); // 3
        System.out.println(gridTraveller(3, 3)); // 6
        System.out.println(gridTraveller(5, 5)); // 70
        System.out.println(gridTraveller(8, 8)); // 3432
        //System.out.println(gridTraveller(18,18)); // Don't run it will hange
    }
}
