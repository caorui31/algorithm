package raymond.project;

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // 使用一个指针记录已经排好序的列表的最后一个节点，初始状态下为第一个节点
        ListNode alreaySortedListEndNode = head;

        while(alreaySortedListEndNode.next != null) {
            int nextVal = alreaySortedListEndNode.next.val;
            if(nextVal > alreaySortedListEndNode.val) {
                // 后面的值比当前值大，直接进行下一次
                alreaySortedListEndNode = alreaySortedListEndNode.next;
                continue;
            }

            // 将下一个节点从链表中断开
            ListNode nextNode = alreaySortedListEndNode.next;
            alreaySortedListEndNode.next = nextNode.next;
            nextNode.next = null;

            // 需要找到插入位置，从head开始找。找到第一个比该节点大的值
            // 如果是插入到第一个位置需要做特殊处理
            if(nextVal < head.val) {
                nextNode.next = head;
                head = nextNode;
            } else {
                ListNode tmp = head;
                while(tmp.val < nextVal) {
                    tmp = tmp.next;
                }
                nextNode.next = tmp.next;
                tmp.next = nextNode;
            }

            alreaySortedListEndNode = alreaySortedListEndNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode(4);
        ListNode head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;

        head = s.insertionSortList(node);
        ListNode.print(head);
    }
}
