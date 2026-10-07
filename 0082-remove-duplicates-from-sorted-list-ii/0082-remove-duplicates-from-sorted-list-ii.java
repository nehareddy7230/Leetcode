class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp = head;
        ListNode temp1 = null;

        ListNode dummy = new ListNode(-1);
        ListNode tdum = dummy;

        while (temp != null && temp.next != null) {

            if (temp.val != temp.next.val &&
                (temp1 == null || temp.val != temp1.val)) {

                tdum.next = temp;
                tdum = tdum.next;
            }

            temp1 = temp;
            temp = temp.next;
        }

        // Handle last node
        if (temp != null &&
            (temp1 == null || temp.val != temp1.val)) {

            tdum.next = temp;
            tdum = tdum.next;
        }

        tdum.next = null;

        return dummy.next;
    }
}