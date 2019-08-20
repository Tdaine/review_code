package LinkList;

/**
 * @author abaka
 * @date 2019/8/20 16:12
 */

//链表逆序
public class Reverse {
    //大思路：遍历原链表，把每隔遍历到结点，头插到新的链表上
    Node reverse(Node head){
        Node cur = head;
        Node newHead = null;
        while (cur != null){

            //记录cur的下一个结点
            Node next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

    Node  reverse2(Node head){
//        if (head == null)
//            return null;
        Node p1 = null;//p1始终指向 p2 的前一个节点
        Node p2 = head;//当前节点
//        Node p3 = head.next;//p2的下一个节点
        //真正遍历的结点应该是当前节点的引用
        while (p2 != null){
            Node p3 = p2.next;//p2的下一个节点
            p2.next = p1;

            p1 = p2;
            p2 = p3;
//            if (p3 != null){
//                p3 = p3.next;
//            }
        }
        return p1;
    }
}
