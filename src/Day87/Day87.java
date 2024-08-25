package Day87;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Day87 {

    public static void main(String[] args) {
        Day87 day87 = new Day87();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(day87.postorderTraversal(root));

    }

    public void traversal(TreeNode root, List<Integer> res){
        if (root != null){
            traversal(root.left, res);
            traversal(root.right, res);
            res.add(root.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
}
