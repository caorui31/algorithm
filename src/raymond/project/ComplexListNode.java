package raymond.project;

import java.util.Random;

public class ComplexListNode{
    public int val;
    public ComplexListNode next;
    public ComplexListNode sibling;

    public ComplexListNode(int val) {
        this.val = val;
    }

    public static ComplexListNode getRandomList(int count) {
        Random random = new Random();
        ComplexListNode head = new ComplexListNode(-1);
        while(count-- > 0) {
            ComplexListNode tmp = new ComplexListNode(random.nextInt( 100));
            tmp.next = head.next;
            head.next = tmp;
        }

        return head.next;
    }

    public static void print(ComplexListNode head) {
        while(head != null) {
            System.out.print(head + ":" + head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
};

