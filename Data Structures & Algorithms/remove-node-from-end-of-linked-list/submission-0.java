/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node banaya
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Slow aur fast dono dummy se start
        ListNode slow = dummy;
        
        ListNode fast = dummy;

        // Fast ko n steps aage le jao
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Dono pointers ko saath-saath chalao
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow ke next node ko delete karo
        slow.next = slow.next.next;

        // Original head return karo
        return dummy.next;

    }
}
