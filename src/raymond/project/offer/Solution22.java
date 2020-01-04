package raymond.project.offer;

import raymond.project.ListNode;

public class Solution22 {

    /**
     * 链表中的倒数第k个节点
     * @return 公共祖先
     */
    ListNode FindKthToTail(ListNode head, int k) throws Exception {
        if(head == null || k < 1) {
            return null;
        }

        ListNode fast = head;
        for(int i = 0;i < k -1; ++i) {
            if(fast.next == null) {
                throw new Exception("k > list.size()");
            }
            fast = fast.next;
        }

        ListNode kNode = head;
        while(fast.next != null) {
            fast = fast.next;
            kNode = kNode.next;
        }

        return kNode;
    }

    public static void main(String[] args) throws Exception{
        ListNode head = ListNode.getRandomList(10);
        ListNode.print(head);
        Solution22 s = new Solution22();
        System.out.println(s.FindKthToTail(head, 5).val);
    }
}
