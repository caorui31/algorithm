package raymond.project.offer;

import raymond.project.ListNode;

public class Solution18 {

    /**
     * O(1)时间删除链表节点
     * @return 公共祖先
     */
    public void deleteNode(ListNode head, ListNode toBeDeletedNode) {
        if(head == null || toBeDeletedNode == null) {
            return ;
        }

        if(toBeDeletedNode.getNext() != null) {
            toBeDeletedNode.val = toBeDeletedNode.next.val;
            toBeDeletedNode.next = toBeDeletedNode.next.next;
        } else if(head == toBeDeletedNode) {
            head = null;
            toBeDeletedNode = null;
        } else {
            ListNode tmp = head;
            while(tmp.next != toBeDeletedNode && tmp.next != null) {
                tmp = tmp.next;
            }
            if(tmp.next == null) {
                return ;
            } else {
                tmp.next = null;
                toBeDeletedNode = null;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ListNode head = ListNode.getRandomList(2);
        ListNode.print(head);
        Solution18 s = new Solution18();
        s.deleteNode(head, head);
        ListNode.print(head);
    }
}
