import java.util.*;

public class NumeroAlunosImpossibilitadosAlmocar {

    public static int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> sandwichesStack = new Stack<>();
        Deque<Integer> studentsDeque = new ArrayDeque<>();

        addToStack(sandwichesStack, sandwiches);
        addToQueue(studentsDeque, students);
        int counter = 0;

        while (!studentsDeque.isEmpty() && (counter < studentsDeque.size())) {
            if (Objects.equals(sandwichesStack.peek(), studentsDeque.peek())) {
                sandwichesStack.pop();
                studentsDeque.pop();
                counter = 0;
            } else {
                studentsDeque.addLast(studentsDeque.removeFirst());
                counter++;
            }
        }
        return counter;
    }

    public static void addToStack(Stack<Integer> stack, int[] whatToAdd) {
        for (int i = whatToAdd.length - 1; i >= 0; i--) {
            stack.push(whatToAdd[i]);
        }
    }

    public static void addToQueue(Deque<Integer> deque, int[] whatToAdd) {
        for (int student : whatToAdd) {
            deque.addLast(student);
        }
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
    }
}
