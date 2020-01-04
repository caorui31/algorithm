package raymond.project.offer;

import raymond.project.ListNode;

public class Solution52 {

    /**
     * 两个链表的公共祖先
     * @return 公共祖先
     */
    public ListNode commonParnet(ListNode l1, ListNode l2) throws Exception{
        if(l1 == null || l2 == null) {
            return null;
        }

        int l1Length = ListNode.getListLength(l1);
        int l2Length = ListNode.getListLength(l2);

        int diff = l1Length - l2Length;

        ListNode longList = l1;
        ListNode shortList = l2;
        if(diff < 0) {
            longList = l2;
            shortList = l1;
            diff = -diff;
        }

        for(int i = 0;i < diff;++i) {
            longList = longList.getNext();
        }

        while(longList != null
                && shortList != null) {
            if(longList.equals(shortList)) {
                return longList;
            }

            longList = longList.getNext();
            shortList = shortList.getNext();
        }

        throw new Exception("invalid list, not have common node");
    }

    public static void main(String[] args) throws Exception{
        ListNode head1 = ListNode.getRandomList(5);
        ListNode head2 = ListNode.getRandomList(5);
        ListNode l1LastNode = ListNode.getLastNode(head1);
        ListNode l2LastNode = ListNode.getLastNode(head2);

        ListNode head3 = ListNode.getRandomList(3);
        l1LastNode.setNext(head3);
        l2LastNode.setNext(head3);
        System.out.println(head3);

        ListNode.print(head1);
        ListNode.print(head2);
        Solution52 s = new Solution52();
        System.out.println(s.commonParnet(head1, head2));
    }
}
