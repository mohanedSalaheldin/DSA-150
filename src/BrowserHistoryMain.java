import java.util.*;

public class BrowserHistoryMain {
    public static void main(String[] args) {

    }
}

class BrowserHistory {
    List<String> history;
    int curIndex;
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curIndex = 0;
    }

    public void visit(String url) {
        history = history.subList(0,curIndex);
        history.add(url);
    }

    public String back(int steps) {

        curIndex = Math.max(curIndex - steps, 0);
        return  history.get(curIndex);
    }

    public String forward(int steps) {
        int n = history.size();
        curIndex = Math.min(curIndex + steps, n-1);
        return  history.get(curIndex);
    }
}
class Node {
    String val;
    Node next;
    Node prev;
    public Node() {
        this.val = "";
        this.next = null;
        this.prev = null;
    }
    public Node(String val, Node prev, Node next) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}



/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */