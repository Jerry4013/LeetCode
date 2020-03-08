package Medium;

public class P207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        int[] in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            in[prerequisites[i][1]]++;
        }
        boolean[] visited = new boolean[prerequisites.length];
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i] && in[prerequisites[i][0]] == 0 && in[prerequisites[i][1]] != 0) {
                    changed = true;
                    in[prerequisites[i][1]]--;
                    visited[i] = true;
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) {
                return false;
            }
        }
        return true;

    }
}
