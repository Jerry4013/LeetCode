package Contest.biweekly42;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by Jingchao Zhang
 * Date: 2020-12-26
 * Time: 10:37 AM
 */
public class P5621 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = Arrays.stream(students)
                                            .boxed()
                                            .collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> sandwichQueue = Arrays.stream(sandwiches)
                                            .boxed()
                                            .collect(Collectors.toCollection(LinkedList::new));
        int count = 0;
        while (count != studentQueue.size()) {
            if (studentQueue.peek().equals(sandwichQueue.peek())) {
                studentQueue.remove();
                sandwichQueue.remove();
                count = 0;
            } else {
                studentQueue.add(studentQueue.remove());
                count++;
            }
        }
        return count;
    }
}
