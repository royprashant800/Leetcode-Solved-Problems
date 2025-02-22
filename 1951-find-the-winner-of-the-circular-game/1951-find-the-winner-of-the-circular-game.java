class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) list.add(i);

        k--;
        int i = 0;
        while(list.size() > 1) {
            i = (i + k) % list.size();
            list.remove(i);
        }
        return list.get(0);
    }
}