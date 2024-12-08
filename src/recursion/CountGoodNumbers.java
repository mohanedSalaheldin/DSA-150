package recursion;

import java.util.*;

public class CountGoodNumbers {
//    boolean isEven(int x){ return x%2==0;}
//    boolean isOdd(int x){ return x%2!=0;}
//    boolean isPrime(int x){
//        ArrayList<Integer> primes = new ArrayList<>(Arrays.asList(2, 3, 5, 7));
//        return primes.contains(x);
//    }

    public int countGoodNumbers(long n) {
        long odds = n/2;
        long evens = n - odds;
        long res = (long) (Math.pow(5, evens) * Math.pow(5, odds));
        return (int)(res % 1_000_000_007);
    }

//    public static void main(String[] args) {
//        CountGoodNumbers c = new CountGoodNumbers();
////        System.out.println(c.calPoints(new { 1,2,3,4,5,6,7,8,9,10});
//    }

    public int[] shuffle(int[] nums, int n) {
       ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(nums[i]);
            res.add(nums[i+n]);
        }
        for (int i = 0; i < n*2; i++) {
            nums[i] = res.get(i);
        }
        return  nums;
    }

    public int[] getConcatenation(int[] nums) {
        int n =  nums.length;
        int[] ans = new int[n*2];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;
    }

    public int calPoints(String[] operations) {
        Stack<Integer> score = new Stack<>();
        int ans = 0;
        for (int i = 0; i < operations.length; i++) {
            String ch = operations[i];
            if (ch.equals("D")) {
                int cur = score.peek() * 2;
                ans+=(cur);
                score.push(cur);
            } else if (ch.equals("C")) {

                int cur = score.pop();
                ans-=cur;
            } else if (ch.equals("+")) {
                int last = score.pop();
                int prelast = score.peek();
                score.push(last);
                int cur = last + prelast;
                ans+=cur;
                score.push(cur);
            }else{
                int cur =Integer.valueOf(ch);
                ans+=cur;
                score.push(cur);
            }
        }
        return ans;
    }

}
