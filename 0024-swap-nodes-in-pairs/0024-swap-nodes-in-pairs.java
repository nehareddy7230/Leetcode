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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        while(temp!=null && temp.next!=null)
        {
            ListNode val1 = temp;
            ListNode val2 = temp.next;
            int temp2 = val1.val;
            val1.val = val2.val;
            val2.val = temp2;
            temp = temp.next.next;
        }
        return head;
    }
}