import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> arr;

    public Heap() {
        this.arr = new ArrayList<>();
        arr.add(0);
    }

    public ArrayList<Integer> getArr() {
        return arr;
    }

    public void push(int val){
        arr.add(val);
        int i = arr.size()-1;
        while (i>1 && arr.get(i) < arr.get(i/2)){
            int temp = arr.get(i);
            arr.set(i, arr.get(i/2));
            arr.set(i/2, temp);
            i/=2;
        }
    }

    public int pop(){
        if (arr.size() == 1)  return 0;
        if (arr.size() == 2)  return arr.get(1);

        int res = arr.get(1);
        arr.set(1, arr.remove(arr.size()-1));
        int i = 1;

        while (i*2<arr.size()){
            if (i*2+1<arr.size() && arr.get(i*2+1)< arr.get(i*2) && arr.get(i)> arr.get(i*2)){
                int temp = arr.get(i);
                arr.set(i, arr.get(i*2+1));
                arr.set(i*2+1, temp);
                i = i*2+1;
            }else if (arr.get(i*2+1)< arr.get(i*2)){
                int temp = arr.get(i);
                arr.set(i, arr.get(i*2));
                arr.set(i*2, temp);
                i = i*2;
            }else
                break;
        }
        return res;
    }
    public int peak(){
        return arr.get(1);
    }
}
