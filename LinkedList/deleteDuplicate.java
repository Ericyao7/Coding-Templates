//1
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head==null ||head.next==null){
            return head;
        }
        ListNode res = head;
        while(head.next!=null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
            
            
        }
        return res;
    }  
}


//2
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        

        //如何用一个while语句来删除所有重复 是关键
        while(head.next!=null&&head.next.next!=null){
            if(head.next.val==head.next.next.val){
                int val = head.next.val;
                while(head.next!=null&&head.next.val==val){
                    head.next = head.next.next;
                }
            }else{
                head=head.next;
            }
        }
        return dummy.next;
    }
}