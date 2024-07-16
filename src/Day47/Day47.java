package Day47;
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

public class Day47 {
    public static void main(String[] args) {
        Day47 day47 = new Day47();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        System.out.println(day47.getDirections(root, 3, 6));
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> pathToStart = new ArrayList<>();
        List<String> pathToDestination = new ArrayList<>();
        findPathFromRoot(root, startValue, pathToStart);
        findPathFromRoot(root, destValue, pathToDestination);
        int commonPathLen = 0;
        while (commonPathLen < pathToStart.size() && commonPathLen < pathToDestination.size() &&
                pathToStart.get(commonPathLen).equals(pathToDestination.get(commonPathLen))) {
            commonPathLen++;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < pathToStart.size() - commonPathLen; i++) {
            res.add("U");
        }
        res.addAll(pathToDestination.subList(commonPathLen, pathToDestination.size()));
        return String.join("", res);
    }

    private boolean findPathFromRoot(TreeNode curNode, int targetValue, List<String> pathToAppend) {
        if (curNode == null) {
            return false;
        }
        if (curNode.val == targetValue) {
            return true;
        }
        pathToAppend.add("R");
        if (findPathFromRoot(curNode.right, targetValue, pathToAppend)) {
            return true;
        }
        pathToAppend.remove(pathToAppend.size() - 1);
        pathToAppend.add("L");
        if (findPathFromRoot(curNode.left, targetValue, pathToAppend)) {
            return true;
        }
        pathToAppend.remove(pathToAppend.size() - 1);
        return false;
    }
}
