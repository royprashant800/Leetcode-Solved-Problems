class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<10; i++) 
            q.add(i);
        
        while(q.size() > 0) {
            int curr = q.poll();
            if(curr >= low && curr <= high)
                res.add(curr);
            int last = curr%10;
            int next = curr * 10 + last + 1;
            if(last < 9 && next <= high)
                q.add(next);
        }
        return res;
    }
}