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
    public boolean hasCycle(ListNode head) {
        
        // Agar list empty hai ya sirf 1 node hai
        // to cycle nahi ho sakti
        if (head == null || head.next == null) {
            return false;
        }

        // Slow 1 step chalega
        ListNode slow = head;

        // Fast 2 steps chalega
        ListNode fast = head;

        // Jab tak fast aur fast.next available hain
        while (fast != null && fast.next != null) {

            // Slow 1 step
            slow = slow.next;

            // Fast 2 steps
            fast = fast.next.next;

            // Agar dono same node par aa gaye
            // cycle present hai
            if (slow == fast) {
                return true;
            }
        }

        // Fast null ho gaya means cycle nahi hai
        return false;
    }
}
