package LinkedLists;

public class test {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    class Solution {

        public static ListNode getNodeof(ListNode head,int pos)
        {
            ListNode temp=head;
            while(temp.val!=pos)
            {
                temp=temp.next;
            }
            return temp;
        }
        public ListNode reverseBetween(ListNode head, int left, int right) {


            ListNode leftlimit =getNodeof(head,left);
            ListNode rightlimit = getNodeof(head,right);
            ListNode curr = leftlimit;

            ListNode temp=head;
            ListNode tail;
            while(temp!=null)
            {
                temp=temp.next;
            }
            tail=temp;

            ListNode prev = tail;

            while(curr!=null)
            {
                //saving next
                ListNode next=curr.next;
                //changing next
                curr.next=prev;
                //traversing
                prev=curr;
                curr=next;
            }

            // tail=head;
            //head=prev;
            head.next=rightlimit;

            return head;
        }

    }

}
