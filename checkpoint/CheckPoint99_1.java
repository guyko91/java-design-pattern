package checkpoint;

import java.util.LinkedList;

public class CheckPoint99_1 {

    public static class Queue<String> {
        private LinkedList<String> q = new LinkedList<String>();

        public boolean addQueue(String element) {
            return q.offer(element);
        }

        public String removeQueue() {
            return q.poll();
        }

        public String peekQueue() {
            return q.peek();
        }


    }

}
