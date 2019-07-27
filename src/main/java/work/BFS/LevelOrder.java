package work.BFS;

import java.util.*;

/**
 * @author abaka
 * @date 2019/7/27 17:02
 */
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class LevelOrder {
    /**
     * N叉树的层序遍历
     */
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            Queue<Node> queue = new LinkedList<Node>();
            List<List<Integer>> arr = new ArrayList<List<Integer>>();
            if (root == null)
                return arr;
            ((LinkedList<Node>) queue).addLast(root);
            while (!queue.isEmpty()){
                int sz = queue.size();
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                while (sz-- > 0){
                    Node curNode = queue.poll();
                    arrayList.add(curNode.val);
                    List<Node> list = curNode.children;
                    for (int i = 0; i < list.size(); i++){
                        ((LinkedList<Node>) queue).addLast(list.get(i));
                    }
                }
                arr.add(arrayList);
            }
            return arr;
        }
    }
}
