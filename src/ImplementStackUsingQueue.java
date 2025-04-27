import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    private Queue<Integer> queue;
    private Queue<Integer> queue2; // helper q

    public ImplementStackUsingQueue() {
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue.isEmpty()) {
            queue2.offer(queue.poll()); // vai dando um por um até queue ficar vazia
        }
        Queue<Integer> temp = queue;
        queue = queue2;
        queue2 = temp;
    }

    public void pop() {
        queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
