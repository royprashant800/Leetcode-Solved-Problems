class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        for(int n=1; n<tasks.length; n++) {
            int[] remain = new int[n];
            for(int i=0; i<n; i++) {
                remain[i] = sessionTime;
            }
            if(canWork(tasks, 0, remain))
                return n;
        }
        return tasks.length;
    }
    private boolean canWork(int[] tasks, int curr, int[] remain) {
        if(curr == tasks.length)
            return true;
        for(int i=0; i<remain.length; i++) {
            if(i > curr) continue;
            if(remain[i] >= tasks[curr]) {
                remain[i] -= tasks[curr];
                if(canWork(tasks, curr + 1, remain))
                    return true;
                remain[i] += tasks[curr];
            }
        }
        return false;
    }
}