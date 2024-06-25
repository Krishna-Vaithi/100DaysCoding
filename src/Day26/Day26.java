package Day26;

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
public class Day26 {
    public static void main(String[] args) {
        Day26 day26 = new Day26();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    TreeNode result = day26.bstToGst(root);
    System.out.println(result.val);
    }

    public TreeNode bstToGst(TreeNode root) {
        int val = 0;
        if (root.right != null) bstToGst(root.right);
        val = root.val = val + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
