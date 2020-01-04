package raymond.project;

import java.util.Random;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }

    public ListNode() {

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode getRandomList(int count) {
        Random random = new Random();
        ListNode head = new ListNode(-1);
        while(count-- > 0) {
            ListNode tmp = new ListNode(random.nextInt( 100));
            tmp.next = head.next;
            head.next = tmp;
        }

        return head.next;
    }

    public static ListNode getRandomSortList(int count) {
        Random random = new Random();
        ListNode head = new ListNode(-1);
        while(count-- > 0) {
            ListNode tmp = new ListNode(random.nextInt( 100));
            tmp.next = head.next;
            head.next = tmp;
        }

        return ListNode.sortList(head.next);
    }

    public static int getListLength(ListNode head) {
        int length = 0;
        ListNode result = head;
        while(result != null) {
            ++length;
            result = result.next;
        }

        return length;
    }

    public static ListNode getLastNode(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode result = head;
        while(result.next != null) {
            result = result.next;
        }

        return result;
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        return mergeSort(sortList(left), sortList(right));
    }

    public static ListNode getMid(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode mergeSort(ListNode l1, ListNode l2) {
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
}
