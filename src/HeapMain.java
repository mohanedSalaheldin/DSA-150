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

        System.out.println(heap.getArr());
        heap.push(17);
        System.out.println(heap.getArr());
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
}