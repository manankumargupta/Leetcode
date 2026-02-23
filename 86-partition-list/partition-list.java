class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode();
        ListNode rightDummy = new ListNode();
      
        ListNode leftTail = leftDummy;
        ListNode rightTail = rightDummy;
      
        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
      
        rightTail.next = null;
      
        leftTail.next = rightDummy.next;
      
        return leftDummy.next;
    }
}