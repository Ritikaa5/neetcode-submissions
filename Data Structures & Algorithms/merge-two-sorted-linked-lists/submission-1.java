
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Step 1: Create a temporary starting node with value -1
        ListNode dummy = new ListNode(-1);

        // Step 2: tail points to the last node of the merged list
        ListNode curr = dummy;

        // Step 3: Continue while both lists have nodes
        while (list1 != null && list2 != null) {

            // Step 4: Compare the current values of both lists
            if (list1.val <= list2.val) {

                // Attach list1's current node to the merged list
                curr.next = list1;

                // Move list1 to its next node
                list1 = list1.next;

            } else {

                // Attach list2's current node to the merged list
                curr.next = list2;

                // Move list2 to its next node
                list2 = list2.next;
            }

            // Move tail to the node we just attached
            curr = curr.next;
        }

        // Step 5: If list1 still has nodes, attach all of them
        if (list1 != null) {
            curr.next = list1;
        }

        // Step 6: Otherwise, attach all remaining nodes of list2
        else {
            curr.next = list2;
        }

        // Step 7: Return the merged list, skipping the dummy node
        return dummy.next;
    }
}
