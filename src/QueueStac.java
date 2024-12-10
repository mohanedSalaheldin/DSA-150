import java.util.*;

public class QueueStac {




    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        int[] arr =  {0, 20, 30, 40};
//        Queue<Integer> queue = new LinkedList(Arrays.asList(arr));
//        System.out.println(queue);

        QueueStac q = new QueueStac();
        int[] arr = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(q.minCostClimbingStairs(arr));

    }


    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for (int num : students) {
            q.add(num);
        }
        Stack<Integer> s = new Stack<>();
        for (int i = sandwiches.length -1 ; i < 0; i++) {
            s.push(sandwiches[i]);
        }
        int n = q.size();
        int count = 0;
        while (!q.isEmpty() && q.size() > count){
            if (q.peek() == s.peek()) {
                q.poll();
                s.pop();
                count = 0;
            }else{
                int temp = q.poll();
                q.add(temp);
                count++;
            }
        }

        return q.size();
    }


    public int climbStairs(int n) {
        if(n == 0 || n == 1)
            return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int minCostClimbingStairs(int[] cost) {
        int lazy = 0;
        int fast = 1;
        int cur= -1,total = 0;
        while (cur < cost.length){
           if (cost[cur+1] > cost[cur+2]){
               total = cost[cur+1];
               cur+=1;
           }else {
               total = cost[cur+2];
               cur+=2;
           }
            System.out.println(cur);
        }
        return total;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] curArr = matrix[i];
            if (search(curArr, target)){
                return true;
            }]
        }
        return  false;
    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int f = 0;
        int l = n-1;
        while (f<=l) {
            int mid = (f+l)/2;
            if (nums[mid]==target) {
                return true;
            }else if (nums[mid] > target) {
                l = mid-1;
            } else {
                f = mid +1;
            }
        }
        return false;
    }



}
