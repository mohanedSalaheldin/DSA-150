package recursion;

import java.util.*;

public class Maps {
    public static void main(String[] args) {

    }
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return true;
            }else{
                map.put(nums[i], 1);
            }
        }
        return false;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = Math.abs(target-nums[i]);
            if (map.containsValue(sub)){
                for (Map.Entry<Integer, Integer> entry : map.entrySet())
                    if (entry.getValue().equals(sub))
                        return new int[] {entry.getKey(),i};
            }else{
                map.put(i, nums[i]);
            }
        }
        return new int[] {-1,-1};
    }
}

class LRUCache {
    int capacity;
    ArrayList<Integer> usage;
    Map<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        usage = new ArrayList<>() {
        };
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            if (usage.contains(key))
                usage.remove(key);
            usage.add(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key, value);
        }else {
            if (cache.size()>=capacity){
                int leastIxd = usage.get(0);
                usage.remove(0);
                cache.remove(leastIxd);
            }else {
                capacity++;
            }
            cache.put(key,value);
        }
    }
}
