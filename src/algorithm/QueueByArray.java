package algorithm;

/**
 * Created by spin on 2/25/17.
 */
public class QueueByArray {
    private int[] queue;
    private int head;
    private int tail;
    private boolean full;
    private int bound;
    private int size;

    public  QueueByArray(int n){
        queue = new int[n];
        head = 0;
        tail = 0;
        bound = n;
        full = false;
        size = 0;
    }

    // insert element at head
    public void offer(Integer k){
        if (full) {
            Util.print("Queue is full, can not offer any more");

        } else {
            queue[head] = k;
            head = (++head) % bound;
            if (head == tail) {
                full = true;
            }
            Util.print(queue);
        }



    }

    // get from tail
    public int poll(){
        int num = queue[tail];
        tail = (++tail) % bound;
        if (head != tail && full){
            full = false;
        }
        return num;

    }

    public int peak(){
        return queue[tail];
    }

    public static void main(String[] args){
        QueueByArray queue = new QueueByArray(4);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(100); // fail
        queue.offer(200); // fail
        Util.print(queue.poll());
        queue.offer(5);
        Util.print(queue.poll());
        Util.print(queue.poll());
        queue.offer(6);
        Util.print(queue.peak());
        Util.print(queue.poll());
        //Util.print(queue.poll());
        //Util.print(queue.poll());
    }

}
