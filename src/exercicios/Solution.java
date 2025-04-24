package exercicios;

public class Solution {

    public int countStudents(int[] students, int[] sandwiches) {
        int count = 0;
        
        while (students.length != 0 && sandwiches.length != 0) {
            if (students[0] == sandwiches[0]) {
                sandwiches = removeElementArrayAtTheTop(sandwiches);
                students = removeElementArrayAtTheTop(students);
                count = 0;
            } else {
                students = rotateStudentToEnd(students);
                count++;
                if (count == students.length) {
                    return students.length;
                }
            }
        }

        return students.length;
    }

    int[] removeElementArrayAtTheTop(int[] arr) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            newArr[i-1] = arr[i];
        }

        return newArr;
    }

    int[] rotateStudentToEnd(int[] students) {
        int[] newArr = new int[students.length];
        
        for (int i = 1; i < students.length; i++) {
            newArr[i - 1] = students[i];
        }
        
        newArr[students.length - 1] = students[0];
        
        return newArr;
    }
}
