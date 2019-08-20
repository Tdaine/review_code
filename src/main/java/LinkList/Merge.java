package LinkList;

/**
 * @author abaka
 * @date 2019/8/20 16:52
 */
public class Merge {
    Node merge(Node h1,Node h2){
        Node c1 = h1;
        Node c2 = h2;
        Node newHead = new Node();
        Node newLast = newHead;
        while (c1 != null && c2 != null){
            if (c1.value <= c2.value){
                //c1尾插
                newLast.next = c1;
                newLast = c1;
            }else {
                //c2尾插
                newLast.next = c2;
                newLast = c2;
            }
        }
        if (c1 != null){
            newLast.next = c1;
        }else {
            newLast.next = c2;
        }
        return newHead.next;
    }
}
