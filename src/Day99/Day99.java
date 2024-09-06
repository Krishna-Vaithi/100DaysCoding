package Day99;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Day99 {
    public static void main(String[] args) {
        Day99 day99 = new Day99();
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = day99.modifiedList(nums, head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        int n = nums.length;
        ListNode ans = new ListNode();
        Set<Integer> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            set.add(curr.val);
            curr = curr.next;
        }
        for (int i=0;i<n;i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }
        }
        ListNode ansHead = null;
        curr = head;
        while (curr!=null) {
            if (set.contains(curr.val)) {
                ans.next = new ListNode(curr.val, null);
                if (ansHead==null) {
                    ansHead = ans;
                }
                ans = ans.next;
            }
            curr = curr.next;
        }
        return ansHead.next;
    }
}
