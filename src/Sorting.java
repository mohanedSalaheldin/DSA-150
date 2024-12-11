public class Sorting {
    public static void main(String[] args) {
        int[] arr = {5,1,1,2,0,0};

        show((quickSort2(arr, 0, arr.length-1)));

    }

    public static void show(int[] nums){
        System.out.println();
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] +",");
        }
        System.out.print("]\n");
    }

    public static int[] insertionsSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int j = i-1;
            while (j>=0 && nums[j+1] < nums[j]){
                int temp = nums[j+1];
                nums[j+1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    }

    public int[] sortArray(int[] nums) {
        return mSort(nums, 0, nums.length-1);
    }
    public int[] mSort(int[] nums, int s, int e) {
        if (s<e) {
            int m = (s+e)/2;
            mSort(nums, s, m);
            mSort(nums, m+1, e);
            merge(nums, s,m, e);
        }
        return nums;
    }

    public void merge(int[] nums, int s, int m,  int e) {
        int len1 = (m-s);
        int len2= (e-(m+1));
        int[] l = new int[len1];
        int[] r = new int[len2];
        for (int i = 0; i < len1; i++) l[i] = nums[s+i];
        for (int i = 0; i < len2; i++) r[i] = nums[i+m+1];
        int p1 = 0, p2=0, pp=s;
        while (p1<len1 && p2<len2){
            if (l[p1]>r[p2]){
                nums[pp] = l[p1];
                p1++;
            }else {
                nums[pp] = r[p2];
                p2++;
            }
            pp++;
        }
        while (1<len1){
            nums[pp] = l[p1];
            p1++;
            pp++;
        }
        while (p2<len2){
            nums[pp] = r[p2];
            p2++;
            pp++;
        }
    }
    public static int[] quickSort(int[] nums, int l, int r) {
        if(r-l+1 <= 1) return nums;

        int pivot = nums[r];
        int i =l;

        for (int j = l; j <= r; j++) {
            if (nums[i] < pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        nums[r] = nums[i];
        nums[i]=pivot;
        quickSort(nums, l, i-1);
        quickSort(nums, i+1, r);
        return nums;
    }


    public static int[] quickSort2(int[] nums, int l, int r) {
        if(r-l+1<=1) return nums;

        int piv = nums[r];
        int cur = l;

        for (int i = l; i <=r ; i++) {
            if (nums[i]<piv){
                int temp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = temp;
                cur++;
            }
        }

        nums[r] = nums[cur];
        nums[cur] = piv;

        quickSort2(nums, l, cur-1);
        quickSort2(nums, cur+1, r);
        return nums;
    }




    public ListNode mergeKLists(ListNode[] lists) {
         if(lists.length==0 || (lists.length==1 && (lists[0]==null ||lists[0].next==null))){
             return null;
         }
        int n = lists.length;
        ListNode res = mergeTwoLists(lists[0], lists[1]);
        for(int i=2 ;i<n;i++){
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }
    public  ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null){
            tail.next = list1;
        }else  if (list2 != null){
            tail.next = list2;
        }
        return  dummy.next;
    }
}


 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;
     }
}