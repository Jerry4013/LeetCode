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
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i]) {
                    if (in[prerequisites[i][0]] == 0 && in[prerequisites[i][1]] != 0) {
                        visited[i] = true;
                        in[prerequisites[i][1]]--;
                        change = true;
                    }
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
