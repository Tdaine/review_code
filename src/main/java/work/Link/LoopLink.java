package work.Link;

import java.util.HashSet;
import java.util.Set;

/**
 * @author abaka
 * @date 2019/7/23 9:26
 */


//Definition for singly-linked list.
 class ListNode {
    int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }


/**
 * 给定一个链表，判断链表中是否有环。
 */
public class LoopLink {
    public boolean hasCucle(ListNode head){
        if(head == null || head.next == null)
            return false;
        ListNode quick = head.next.next;
        ListNode slow = head;
        while (quick != null && quick.next != null){
            if (slow.val == quick.val)
                return true;
            quick = quick.next.next;
            slow = slow.next;
        }
        return false;
    }

    public boolean solution(ListNode head){
        ListNode fast = head,slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public boolean solution1(ListNode head){
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null){
            if (set.contains(head))
                return true;
            else
                set.add(head);
            head = head.next;
        }
        return false;
    }
}
