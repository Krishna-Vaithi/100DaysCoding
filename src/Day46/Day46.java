package Day46;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Day46 {
    public static void main(String[] args) {
        Day46 day46 = new Day46();
        int[][] arr = {{1, 2, 0}, {1, 3, 1}, {2, 4, 0}, {2, 5, 1}};
        TreeNode root = day46.createBinaryTree(arr);
        System.out.println(root.val);
    }
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
        public TreeNode createBinaryTree(int[][] arr) {
            Map<Integer,TreeNode> map=new HashMap<>();
            Set<Integer> set=new HashSet<>();

            for(int[] a:arr){
                int parent=a[0];
                int child=a[1];
                int isLeft=a[2];
                TreeNode p=map.getOrDefault(parent,new TreeNode(parent));
                set.add(child);
                if(isLeft==1){
                    p.left=map.getOrDefault(child,new TreeNode(child));
                    map.put(child,p.left);
                }
                else{
                    p.right=map.getOrDefault(child,new TreeNode(child));
                    map.put(child,p.right);
                }
                map.put(parent,p);
            }
            for(int[] a:arr){
                if(!set.contains(a[0])) return map.get(a[0]);
            }
            return null;
        }
}
