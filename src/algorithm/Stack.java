package algorithm;

public class Stack {
    ListNode head;

    public Integer pop(){
        if ( this.head == null){
            return null;
        } else {
            Integer value = head.value;
            head = head.next;
            return value;
        }
    }

    public boolean push(int value){
        ListNode newNode = new ListNode(value);
        if (this.head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        return true;
    }
    
    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(1);
        Util.print(stack.pop());
    }
}
