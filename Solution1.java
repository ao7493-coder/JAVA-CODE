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
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to simplify head tracking
        ListNode current = dummyHead;         // Pointer to build the new list
        int carry = 0;                        // Stores carry-over from additions

        // Loop until both lists are fully traversed AND there is no remaining carry
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;                 // Tens place becomes next carry
            int digit = sum % 10;             // Ones place becomes node value

            current.next = new ListNode(digit);
            current = current.next;

            // Move pointer forward if node exists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; // Return actual head of the result list
    }
}
