package Day100;

import javafx.util.Pair;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day100 {
    public static void main(String[] args) {
        Day100 day100 = new Day100();
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(8)));
        TreeNode root = new TreeNode(1, new TreeNode(4, new TreeNode(2), new TreeNode(8)), new TreeNode(1));
        System.out.println(day100.isSubPath(head, root));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;

        Stack<Pair<TreeNode, ListNode>> stk = new Stack<>();
        stk.push(new Pair<>(root, head));

        while (!stk.isEmpty()) {
            Pair<TreeNode, ListNode> current = stk.pop();
            TreeNode node = current.getKey();
            ListNode list = current.getValue();

            if (node == null) continue;

            if (isMatch(node, list)) return true;

            if (node.left != null) stk.push(new Pair<>(node.left, head));
            if (node.right != null) stk.push(new Pair<>(node.right, head));
        }

        return false;
    }

    private boolean isMatch(TreeNode node, ListNode list) {
        while (node != null && list != null) {
            if (node.val != list.val) return false;
            list = list.next;
            if (list != null) {
                node = (node.left != null && isMatch(node.left, list)) ? node.left : node.right;
            }
        }
        return list == null;
    }
}
