package raymond.project.offer;

import raymond.project.ListNode;

public class Solution25 {

    /**
     * 合并两个有序链表
     * @return
     */
    ListNode mergeList(ListNode l1, ListNode l2) throws Exception {
        ListNode head = null;
        if(l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode node = head;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            } else {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        }

        if(l1 != null) {
            node.next = l1;
        }
        if(l2 != null) {
            node.next = l2;
        }

        return head;
    }

    public static void main(String[] args) throws Exception{
        ListNode head1 = ListNode.getRandomSortList(5);
        ListNode.print(head1);

        ListNode head2 = ListNode.getRandomSortList(5);
        ListNode.print(head2);

        Solution25 s = new Solution25();
        ListNode head = s.mergeList(head1, head2);
        ListNode.print(head);
    }
}
