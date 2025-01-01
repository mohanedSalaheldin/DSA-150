import java.util.*;

public class Dp {
    public int climbStairsMemo(int n) {
        return memo(n, new HashMap<Integer, Integer>());
    }
    private int memo(int n, HashMap<Integer, Integer> cache){
        if (n==0 || n==1)
            return 1;
        if (!cache.containsKey(n)){
            cache.put(n, memo(n-1, cache)+  memo(n-2, cache));
        }
        return cache.get(n);
    }

    public int climbStairsDP(int n) {
        int one = 1, two = 1;
        for (int i = 0; i < n-1; i++) {
            int temp = one;
            one= one+two;
            two = temp;
        }
        return one;
    }
}
