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
    public void reorderList(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        ListNode secondHalfHead = slowPointer.next;
        slowPointer.next = null;

        ListNode previousNode = null;
        ListNode currentNode = secondHalfHead;

        while(currentNode != null) {
            ListNode nextTemp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextTemp;
        }

        ListNode firstHalfCurrent = head;
        ListNode secondHalfCurrent = previousNode;

        while(secondHalfCurrent != null) {
            ListNode firstHalfNext = firstHalfCurrent.next;
            ListNode secondHalfNext = secondHalfCurrent.next;

            firstHalfCurrent.next = secondHalfCurrent;
            secondHalfCurrent.next = firstHalfNext;

            firstHalfCurrent = firstHalfNext;
            secondHalfCurrent = secondHalfNext;
        }
    }
}