package Day35;

public class Day35 {

    public static void main(String[] args) {
        Day35 day35 = new Day35();
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        ListNode result = day35.mergeNodes(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode prev = head.next, curr = head.next;
        int sum = 0;
        for (; curr != null; curr = curr.next) {
            int x = curr.val;
            if (x != 0) sum += x;
            else {
                prev.val = sum;
                prev.next = curr.next;
                prev = prev.next;
                sum = 0;
            }
        }
        return head.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
