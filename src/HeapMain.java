import java.util.*;

public class HeapMain {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.push(14);
        heap.push(19);
        heap.push(16);
        heap.push(21);
        heap.push(26);
        heap.push(19);
        heap.push(68);
        heap.push(65);
        heap.push(30);

//        System.out.println(heap.getArr());
//        heap.push(17);
//        System.out.println(heap.getArr());

        Integer[] array = {5, 1, 3, 7, 9, 2};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.addAll(Arrays.asList(array));
        // Print the PriorityQueue
        System.out.println(priorityQueue);
        priorityQueue.poll();
        System.out.println(priorityQueue);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            pq.offer(s);
        }
        while (pq.size()>1){
            int y = pq.poll();
            int x = pq.poll();
            if (x!=y){
                pq.offer(y-x);
            }
        }
        return pq.size()== 0 ? 0 : pq.peek().intValue();
    }

    public int[][] kClosest(int[][] points, int k) {
        if (points.length==1) {
            return points;
        }
        Comparator<int[]> myComparator = (a, b) -> {
            double sumA = calcDes(a);
            double sumB = calcDes(b);
            return Double.compare(sumB, sumA);
        };
        PriorityQueue<int[]> pq = new PriorityQueue(myComparator);
        pq.addAll(Arrays.asList(points));
        int[][] res = new int[2][k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public double calcDes(int[] x){
        double sum = Math.pow  (x[1],2) + Math.pow  (x[0],2) ;
        return Math.sqrt(sum);
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if(q.size()<k){
                q.offer(nums[i]);
            } else if(nums[i] > q.peek()){
                q.offer(nums[i]);
                if(q.size()>k){
                    q.poll();
                }
            }
        }
        return q.peek();
    }
}

class KthLargest {
    PriorityQueue<Integer> q;
    int k;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        for (int num:nums) {
            if (k>q.size()){
                q.offer(num);
            } else if (q.peek()>num){
                q.offer(num);
                if (k> q.size()){
                    q.poll();
                }
            }
        }
    }

    public int add(int val) {
        if (k>q.size()){
            q.offer(val);
        } else if (q.peek()>val){
            q.offer(val);
            if (k> q.size()){
                q.poll();
            }
        }
        return q.peek();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        compRec(candidates, target, 0,  0,  new ArrayList<>() ,   res);
        return res;
    }
    void compRec(int[] candidates, int target, int total, int idx, List<Integer> sub ,  List<List<Integer>> res){
        if (idx>=candidates.length || total > target) return;
        if(total == target) {
            res.add(sub);
            return;
        }
        sub.add(candidates[idx]);
        compRec(candidates, target, total + candidates[idx],  idx,  sub ,   res);
        sub.remove(sub.size()-1);
        compRec(candidates, target, total,  idx+1,  sub ,   res);
    }
}