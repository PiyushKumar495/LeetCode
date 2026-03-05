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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0);
        ListNode cu=res;
        int c=0;
        while(l1!=null && l2!=null)
        {
            int s=c+l1.val+l2.val;
            cu.next=new ListNode(s%10);
            cu=cu.next;
            l1=l1.next;
            l2=l2.next;
            c=s/10;
            
        }
        while(l1!=null)
        {
            int s=c+l1.val;
            cu.next=new ListNode(s%10);
            cu=cu.next;
            l1=l1.next;
            c=s/10;
            
        }
        while(l2!=null)
        {
            int s=c+l2.val;
            cu.next=new ListNode(s%10);
            cu=cu.next;
            l2=l2.next;
            c=s/10;
            
        }
        if (c>0)
        cu.next=new ListNode(c);

        return res.next;
        
    }
}