import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class NumberStudentsUnableEatLunch {

    public static int numberOfStudents(int[] students, int[] sandwiches) {
        Stack<Integer> sandwichesStack = new Stack<>();
        Queue<Integer> studentsQueue = new ArrayDeque<>();

        addToStackAndQueue(sandwiches, sandwichesStack, students, studentsQueue);

        int studentsNoSandwitches = 0;
        int rotations = 0; // we need to check if the rotations we got
        // from a student are smaller than the size of the array with the
        // students, since we need to know how many students we have
        // and how many sandwiches are unable to be eaten
        int queueSize = studentsQueue.size();

        while (!studentsQueue.isEmpty() && rotations < queueSize) {
            if (Objects.equals(studentsQueue.peek(), sandwichesStack.peek())) {
                studentsQueue.poll();
                sandwichesStack.pop(); //pop stack and queue (rm top of stack and first in queue)
                rotations = 0; // return the rotations of the students back to 0
                queueSize--; // decrement the size of the queue by 1
            } else {
                int firstStudentInLine = studentsQueue.poll();
                studentsQueue.offer(firstStudentInLine); // pop student and make him the last in line again
                rotations++;
            }
        }

        studentsNoSandwitches = studentsQueue.size();
        return studentsNoSandwitches;
    }

    public static void addToStackAndQueue(int[] toStack, Stack<Integer> stack, int[] toQueue, Queue<Integer> queue) {
        for (int i = toStack.length - 1; i >= 0; i--) {
            stack.push(toStack[i]);
        }

        for (int student : toQueue) {
            queue.offer(student);
        }
    }

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        System.out.println(numberOfStudents(students, sandwiches));
    }
}
