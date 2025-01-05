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

    public int rob(int[] nums) {
        int rob1=0, rob2=0;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(nums[i]+rob1,rob2 );
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

    public int uniquePaths(int m, int n) {
        return memo(0,0, m, n, new int[m][n]);
    }

    int memo(int r, int c, int rows, int cols, int[][] cache){
        if (r==rows || c==cols)
            return 0;
        if (cache[r][c]>0)
            return cache[r][c];
        if (r==rows-1 || c==cols-1)
            return 1;
        cache[r][c] = memo(r,c+1, rows, cols, cache) + memo(r+1,c, rows, cols, cache);
        return cache[r][c];
    }



    int bruteForce(int r, int c, int rows, int cols){
        if (r==rows || c==cols)
            return 0;
        if (r==rows-1 || c==cols-1)
            return 1;
        return bruteForce(r,c+1, rows, cols)+bruteForce(r+1,c, rows, cols);
    }


    public int maxScore(String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1')
                ones++;

        }
        int ans = 0;
        int zeros = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i)=='0')
                zeros++;
            else
                ones--;
            ans = Math.max(ans, zeros+ones);
        }
        return ans;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {

        HashMap<Integer, Boolean> cache = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
                cache.put(i, isVowel(cur.charAt(0)) && isVowel(cur.charAt(cur.length()-1)));
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] curQuery = queries[i];
            for (int j = curQuery[0]; j <= curQuery[curQuery.length-1]; j++) {
                if (cache.get(j))
                    ans[i]++;
            }
        }
        return ans;
    }
    boolean isVowel(char ch){
        return ch == 'a'
                || ch == 'e'
                || ch == 'i'
                || ch == 'o'
                || ch == 'u';
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffArray = new int[n]; // Initialize a difference array with all elements set to 0.

        // Process each shift operation
        for (int[] shift : shifts) {
            if (shift[2] == 1) { // If direction is forward (1)
                diffArray[shift[0]]++; // Increment at the start index
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]--; // Decrement at the end+1 index
                }
            } else { // If direction is backward (0)
                diffArray[shift[0]]--; // Decrement at the start index
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]++; // Increment at the end+1 index
                }
            }
        }

        StringBuilder result = new StringBuilder(s);
        int numberOfShifts = 0;

        // Apply the shifts to the string
        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + diffArray[i]) % 26; // Update cumulative shifts, keeping within the alphabet range
            if (numberOfShifts < 0) numberOfShifts += 26; // Ensure non-negative shifts

            // Calculate the new character by shifting `s[i]`
            char shiftedChar = (char) ('a' +
                    ((s.charAt(i) - 'a' + numberOfShifts) % 26));
            result.setCharAt(i, shiftedChar);
        }

        return result.toString();
    }
}
