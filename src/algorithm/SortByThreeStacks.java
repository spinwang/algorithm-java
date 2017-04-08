package algorithm;

import java.util.LinkedList;

/**
 * Created by spin on 2/20/17.
 */
public class SortByThreeStacks {
    public void sort(LinkedList<Integer> s1){
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();

        while (s1.size() > 0 ) {
            Integer global_min = s1.peekFirst();
            int s2Length = s2.size();
            while (s1.isEmpty()) {
                Integer elem = s1.pollFirst();
                if (elem < global_min) {
                    global_min = elem;
                }
                s2.offerFirst(elem);
            }
            s3.offerFirst(global_min);
            s1.offerFirst(global_min);
            boolean firstGlobalMin = true;
            while (s2.size() > s2Length) {
                Integer elem = s2.pollFirst();
                if ((elem == global_min) && firstGlobalMin) {
                    firstGlobalMin = false;
                } else {
                    s1.offerFirst(elem);
                }
            }
        }
    }


}
