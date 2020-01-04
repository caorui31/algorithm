package raymond.project.offer;

import raymond.project.ListNode;

public class Solution23 {

    /**
     * 链表中环的入口节点
     * 快慢指针
     * @return
     */
    ListNode EntryNodeOfLoop(ListNode head) throws Exception {
        ListNode meetNode = MettingNode(head);

        if(meetNode == null) {
            return null;
        }

        int loopCount = 1;
        ListNode tmp = meetNode;
        while(tmp.next != meetNode) {
            tmp = tmp.next;
            loopCount++;
        }

        ListNode node1 = head;
        for(int i = 0;i < loopCount;++i) {
            node1 = node1.next;
        }

        ListNode node2 = head;
        while(!node1.equals(node2)) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    ListNode MettingNode(ListNode head) throws Exception {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = slow.next;

        while(fast != null && slow != null) {
            if(fast.equals(slow)) {
                return fast;
            }

            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }

        return fast;
    }

    public static void main(String[] args) throws Exception{
        ListNode head = ListNode.getRandomList(10);
        ListNode.print(head);
        ListNode lastNode = ListNode.getLastNode(head);
        lastNode.next = head.next.next.next;
        Solution23 s = new Solution23();
        System.out.println(s.EntryNodeOfLoop(head).val);
    }
}
