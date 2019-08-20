package LinkList;

/**
 * @author abaka
 * @date 2019/8/20 15:18
 */
public class RemoveAll {
    //创建一个新的链表
    Node removeAll(Node head,int value){
        if (head == null){
            return null;
        }
        Node newList = new Node();
        Node newP = newList;
        Node cur = head;
        while (cur != null){


            //cur 指向正在比较的结点
            if (cur.value != value){
                newP.next = cur;
                newP = newP.next;
            }
            cur = cur.next;
        }
        newP.next = null;
        return newList.next;
    }

    //设置前驱节点
    Node removeAll2(Node head,int value){
        if (head == null){
            return null;
        }
        Node prev = head;
        Node cur = head.next;
        while (cur != null){
            if (cur.value == value){
                cur = cur.next.next;
            }else {
                prev.next = cur;
                prev = prev.next;
                cur = cur.next;
            }
        }
        prev.next = null;
        if (head.value == value){
            return head.next;
        }
        return head;
    }

    //设置假结点
    Node removeAll3(Node head,int value){
        if (head == null){
            return null;
        }
        Node fakeHead = new Node();
        Node cur = head;
        Node prev = fakeHead;
        while (cur != null){
            if (cur.value == value){
                cur = cur.next.next;
            }else {
                prev.next = cur;
                prev = prev.next;
                cur = cur.next;
            }
        }
        prev.next = null;
        return fakeHead.next;
    }
}
