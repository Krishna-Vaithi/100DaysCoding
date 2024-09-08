package Day101;

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

public class Day101 {
    public static void main(String[] args) {
        Day101 day101 = new Day101();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 3;
        ListNode[] res = day101.splitListToParts(head, k);
        for (ListNode node : res) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];

        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        int splitSize = size / k;

        int numRemainingParts = size % k;

        current = head;
        ListNode prev = current;
        for (int i = 0; i < k; i++) {
            ListNode newPart = current;
            int currentSize = splitSize;
            if (numRemainingParts > 0) {
                numRemainingParts--;
                currentSize++;
            }

            int j = 0;
            while (j < currentSize) {
                prev = current;
                current = current.next;
                j++;
            }
            if (prev != null) {
                prev.next = null;
            }

            ans[i] = newPart;
        }

        return ans;
    }
}
