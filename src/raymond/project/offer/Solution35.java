package raymond.project.offer;

import raymond.project.ComplexListNode;
import raymond.project.ListNode;


public class Solution35 {





    /**
     * 复杂链表的复制
     * 1.复制每一个节点
     * 2.赋值sibling
     * 3.断开链表
     * @return
     */
    ComplexListNode Clone(ComplexListNode head) throws Exception {
        copyList(head);
        setSibling(head);
        return reconnectNodes(head);
    }

    void copyList(ComplexListNode head) {
        if(head == null) {
            return ;
        }

        while(head != null) {
            ComplexListNode node = new ComplexListNode(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
    }

    void setSibling(ComplexListNode head) {
        if(head == null) {
            return ;
        }

        while(head != null && head.next != null) {
            ComplexListNode copyNode = head.next;
            if(head.sibling != null) {
                copyNode.sibling = head.sibling.next;
            }
            head = copyNode.next;
        }
    }

    ComplexListNode reconnectNodes(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode cloneHead = null;
        ComplexListNode cloneNode = null;

        if(node != null && node.next != null) {
            cloneHead = cloneNode = node.next;
            node.next = cloneHead.next;
            node = node.next;
        }

        while(node != null && node.next != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }

        return cloneHead;
    }

    public static void main(String[] args) throws Exception{
        ComplexListNode head = ComplexListNode.getRandomList(5);
        ComplexListNode.print(head);

        Solution35 s = new Solution35();
        ComplexListNode newHead = s.Clone(head);
        ComplexListNode.print(newHead);
    }
}
