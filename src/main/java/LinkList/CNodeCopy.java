package LinkList;

/**
 * @author abaka
 * @date 2019/8/20 21:38
 */
public class CNodeCopy {
    Node copy(CNode head){
        if (head == null)
            return null;
        //进行链表的拷贝
        CNode cur = head;

        while (cur != null){
            CNode newNode = new CNode(cur.value);
            newNode = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        //进行链表的random复制
        cur = head;
        CNode newNode ;
        while (cur != null){
            newNode = head.next;
            if (cur.random != null){
                newNode.random = cur.random.next;
            }else {
                newNode.random = null;
            }
            cur = newNode.next;
        }

        //拆分
        cur = head;
        CNode newHead = cur.next;
        newNode = newHead;
        while (cur != null){
            cur = newNode.next;
            newNode = cur.next;
        }

        return newHead;
    }
}
