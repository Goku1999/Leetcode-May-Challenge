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
class Solution 
{
    public ListNode oddEvenList(ListNode head) 
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        while(odd!=null&&even!=null&&odd.next!=null&&even.next!=null)
        {
            ListNode t=even;
            ListNode r=even.next;
            ListNode n=odd.next;
            odd.next=r;
            t.next=r.next;
            r.next=n;
            odd=r;
            even=t;
            even=even.next;
        }
        return head;
    }
}
