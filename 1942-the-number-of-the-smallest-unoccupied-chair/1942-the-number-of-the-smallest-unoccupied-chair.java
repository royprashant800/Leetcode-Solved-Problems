class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        Pair[] friendTimes = new Pair[times.length];
        for(int i = 0; i < times.length; i++)
            friendTimes[i] = new Pair(times[i][0], times[i][1], i);
        
        Arrays.sort(friendTimes, (a, b) -> a.arrival == b.arrival ? Integer.compare(a.depart, b.depart) : Integer.compare(a.arrival, b.arrival));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> seatsAvailable = new PriorityQueue<>();
        
        int maxSeatAvailable = 0;
        for(int i = 0; i < friendTimes.length; i++) {
            while(!pq.isEmpty() && pq.peek()[0] <= friendTimes[i].arrival) {
                seatsAvailable.offer(pq.poll()[1]);
            }
            if(friendTimes[i].index == targetFriend) {
                if(seatsAvailable.isEmpty()) return maxSeatAvailable;
                else return seatsAvailable.poll();
            }
            if(seatsAvailable.isEmpty()) {
                pq.offer(new int[]{friendTimes[i].depart, maxSeatAvailable});
                maxSeatAvailable++;
            } 
            else pq.offer(new int[]{friendTimes[i].depart, seatsAvailable.poll()});
        }
        return maxSeatAvailable;
    }
}
class Pair {
    int arrival;
    int depart;
    int index;
    public Pair(int arrival, int depart, int index) {
        this.arrival = arrival;
        this.depart = depart;
        this.index = index;
    }
}