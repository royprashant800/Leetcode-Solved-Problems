class Server {
    int weight;
    int index;
    public Server(int weight, int index) {
        this.weight = weight;
        this.index = index;
    }
} 

class Assign {
    int freeTime;
    Server server;
    public Assign(int freeTime, Server server) {
        this.freeTime = freeTime;
        this.server = server;
    }
}

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        Queue<Server> serverQueue = new PriorityQueue<>((s1, s2) -> {
            if(s1.weight - s2.weight != 0)
                return s1.weight - s2.weight;
            return s1.index - s2.index;
        });
        Queue<Assign> assignQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.freeTime));
        for(int i = 0; i < servers.length; i++)
            serverQueue.add(new Server(servers[i], i));
        
        int j = 0, time = 0;
        int[] ans = new int[tasks.length];
        
        while(j < tasks.length) {
            while(!assignQueue.isEmpty() && assignQueue.peek().freeTime <= time) {
                serverQueue.add(assignQueue.poll().server);
            }
            while(!serverQueue.isEmpty() && j <= time && j < tasks.length) {
                int task = tasks[j];
                Server server = serverQueue.poll();
                ans[j] = server.index;
                assignQueue.add(new Assign(time + task, server));
                j++;
            }
            if(!serverQueue.isEmpty())
                time++;
            else
                time = assignQueue.peek().freeTime;
        }
        return ans;
    }
}