/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/




class Solution {
    public Node copyRandomList(Node head) {

        // If the original list is empty, return null
        if (head == null) {
            return null;
        }

        // Store mapping: Original Node -> Copied Node
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;

        // Step 1: Create a copy of every node
        while (curr != null) {

            // Create a new node with the same value
            Node newNode = new Node(curr.val);

            // Store the original node and its copy in the map
            map.put(curr, newNode);

            // Move to the next original node
            curr = curr.next;
        }

        // Start again from the original head
        curr = head;

        // Step 2: Connect next and random pointers
        while (curr != null) {

            // Get the copy of the current original node
            Node copy = map.get(curr);

            // Connect the copied node to the copied next node
            // If curr.next is null, map.get(null) also returns null
            copy.next = map.get(curr.next);

            // Connect the copied node to the copied random node
            // If curr.random is null, map.get(null) also returns null
            copy.random = map.get(curr.random);

            // Move to the next original node
            curr = curr.next;
        }

        // Return the head of the copied linked list
        return map.get(head);
    }
}
