package raymond.project.offer;

import raymond.project.ListNode;

public class Solution24 {

    /**
     * 反转链表
     * @return
     */
    ListNode reverseList(ListNode head) throws Exception {
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) throws Exception{
        ListNode head = ListNode.getRandomList(5);
        ListNode.print(head);
        Solution24 s = new Solution24();
        ListNode newHead = s.reverseList(head);
        ListNode.print(newHead);
    }
}
