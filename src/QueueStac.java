import java.util.*;

public class QueueStac {




    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayDeque<>();
        int[] arr =  {0, 20, 30, 40};
        Queue<Integer> queue = new LinkedList(Arrays.asList(arr));
        System.out.println(queue);

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


}
