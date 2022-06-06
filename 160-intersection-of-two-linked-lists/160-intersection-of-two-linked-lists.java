/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return headA==null?headB:headA;
        }
        ListNode ptr1=headA,ptr2=headB;
        while(ptr1!=ptr2){
            if(ptr1==ptr2)break;
            ptr1=ptr1==null?headB:ptr1.next;
            ptr2=ptr2==null?headA:ptr2.next;
        }
        return ptr1;
    }
}