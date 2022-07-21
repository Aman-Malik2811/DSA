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
    private ListNode reverseList(ListNode head){
        ListNode temp=head,prev=null;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null)return head;
        ListNode prev=null,curr=head;
        while(left>1){
            prev=curr;
            curr=curr.next;
            left--;right--;
        }
        ListNode st=curr;
        while(right>1){
            right--;
            curr=curr.next;
        }
        ListNode en=curr.next;
        curr.next=null;
        ListNode ans=reverseList(st);
       // System.out.println(st.val+"  "+ans.val+" "+en.val);
        if(prev!=null)prev.next=ans;
        else head=ans;
        st.next=en;
        return head;
        
    }
}