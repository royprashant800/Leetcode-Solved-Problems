class Solution {
    public String repeatLimitedString(String s, int r) {
        int f[] = new int[26];
        for (char ch : s.toCharArray()) {
            f[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]); 
        for (int i = 0; i < 26; i++) {
            if (f[i] != 0) pq.add(new int[] { i, f[i] });
        }
        while (!pq.isEmpty()) {
            int curr[] = pq.remove();
            boolean rem = false;
            while (curr[1] != 0) {
                if (rem) { 
                    if (pq.isEmpty()) break;
                    sb.append((char) (pq.peek()[0] + 'a'));
                    pq.peek()[1]--;
                    rem = false;
                }
                int temp = Math.min(curr[1], r);
                int x = temp;
                while (temp-- > 0) {
                    sb.append((char) (curr[0] + 'a'));
                }
                curr[1] -= x;
                if (!pq.isEmpty() && pq.peek()[1] == 0) pq.remove(); 
                if (curr[1] != 0) rem = true; 
            }
        }
        return sb.toString();
    }
}