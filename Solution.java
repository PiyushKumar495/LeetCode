class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int cnt = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            cnt++;
        }

        tail.next = head; // make circular

        k = k % cnt;
        if (k == 0) {
            tail.next = null;
            return head;
        }

        int steps = cnt - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}