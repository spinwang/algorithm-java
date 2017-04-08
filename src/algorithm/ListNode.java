package algorithm;


/**
 * Created by spin on 2/20/17.
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value){
        this.value = value;
        this.next = null;
    }


    public static ListNode reverse(ListNode head){
        if (head == null) {
            return null;
        } else if (head.next == null){
            return head;
        } else {

            ListNode newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

    }

    public ListNode insert(ListNode head, int value){
        ListNode node = new ListNode(value);
        if ( head == null || value <= head.value ){
            node.next = head;
            return node;
        }

        ListNode left = head;
        while ( left.next != null && left.next.value < value){
            left = left.next;
        }

        ListNode right = left.next;
        left.next = node;
        node.next = right;
        return head;
    }

    public static ListNode middleNode(ListNode head){
        if (head == null){
            return null;
        } else if (head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        return slow;
    }
}
