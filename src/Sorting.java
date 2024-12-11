public class Sorting {
    public static void main(String[] args) {
        int[] arr = {5,1,1,2,0,0};
        show((arr));

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


}
