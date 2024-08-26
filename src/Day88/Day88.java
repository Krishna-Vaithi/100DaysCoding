package Day88;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Day88 {
    public static void main(String[] args) {
        Day88 day88 = new Day88();
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        List<Node> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        root.children = list;
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        List<Node> list1 = new ArrayList<>();
        list1.add(node4);
        list1.add(node5);
        node1.children = list1;
        List<Integer> list2 = day88.postorder(root);
        for (int i : list2) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (Node node : root.children) {
                stack.add(node);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
