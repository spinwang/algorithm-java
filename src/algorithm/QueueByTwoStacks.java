package algorithm;


import java.util.LinkedList;

public class QueueByTwoStacks {

    // imagine first as stack's top
    private LinkedList<Integer> in;
    private LinkedList<Integer> out;

    public QueueByTwoStacks() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    public Integer poll() {
        move();
        return out.isEmpty() ? null : out.pollFirst();
    }

    // push into the queue
    public void offer(int element) {
        in.offerFirst(element);
    }


    public Integer peek() {
        move();
        return out.isEmpty() ? null : out.peekFirst();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void move(){
        // todo: what if we do not check out.isEmpty
        if ( out.isEmpty() ){
            while ( !in.isEmpty() ){
                out.offerFirst(in.pollFirst());
            }
        }
    }

    public static void main(String[] args){

    }
}