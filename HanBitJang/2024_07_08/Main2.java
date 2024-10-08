// Tree 말단노드까지의 가장 짧은 경로 - BFS 풀이
import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Main2 {
    Node root;

    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if (cur.lt == null && cur.rt == null) {
                    return L;
                }
                if (cur.lt != null) {
                    Q.offer(cur.lt); // add도 가능
                }
                if (cur.rt != null) {
                    Q.offer(cur.rt); // add도 가능
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main2 tree = new Main2();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}


