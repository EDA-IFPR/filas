package fifo;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Sandwich {
    public static int unableStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stackSandwiches = new Stack<>();
        Queue<Integer> queueStudents = new LinkedList<>();
        fillStack(stackSandwiches, sandwiches);
        fillQueue(queueStudents, students);

        int unable = 0;

        while(!stackSandwiches.isEmpty() && unable < queueStudents.size()) {
            if(stackSandwiches.peek().equals(queueStudents.peek())) {
                stackSandwiches.pop();
                queueStudents.poll();
                unable = 0;
            } else {
                int firstStudent = queueStudents.poll();
                queueStudents.offer(firstStudent);
                unable++;
            }
        }

        return queueStudents.size();
    }

    private static void fillStack (Stack<Integer> stack, int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            stack.push(array[i]);
        }
    }

    private static void fillQueue (Queue<Integer> queue, int[] array) {
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }
    }
}
