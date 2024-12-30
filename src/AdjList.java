import java.util.*;

public class AdjList {

    public void buildGraph(){
        String[][] edges = {{"A", "B"}, {"B", "C"}, {"B", "E"}, {"C", "E"}, {"E", "D"}};
        ArrayList<Integer> vis = new ArrayList<>();
        HashMap<String, ArrayList<String>> grph = new HashMap<>();

        for (String[] pair: edges) {
            String src = pair[0], dst = pair[1];
            if (!grph.containsKey(src)) {
                grph.put(src, new ArrayList<>());
            }
            if (!grph.containsKey(dst)) {
                grph.put(dst, new ArrayList<>());
            }
            grph.get(src).add(dst);
        }
    }

    public int dfsAdjList(String start, String end, HashMap<String, ArrayList<String>> g, HashSet<String> visited){
        if(visited.contains(start))
            return 0;
        if(start == end)
            return 1;

        int count = 0;
        visited.add(start);
        for (String n: g.get(start)) {
            count+= dfsAdjList(n,end, g, visited);
        }
        visited.remove(start);
        return count;
    }

    public int bfsAdjList(String start, String end, HashMap<String, ArrayList<String>> g){
       Queue<String> queue = new LinkedList();
       queue.add(start);
       HashSet<String> visited = new HashSet<>();
       visited.add(start);

       int len = 0;
       while (!queue.isEmpty()){
           for (int i = 0; i < queue.size(); i++) {
               String cur  = queue.poll();

               if (cur == end)
                   return len;
               for(String nigh: g.get(cur)){
                   if (!visited.contains(nigh)){
                       queue.add(nigh);
                       visited.add(nigh);
                   }
               }
           }
           len++;
       }
       return len;
    }
}
