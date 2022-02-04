class Solution {
 public int[] groupStrings(String[] words) {
        HashMap<Integer, Integer> counts = new HashMap<>(), indices = new HashMap<>();
        int n = words.length, output = 0;
        int[] masks = new int[n], uf = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) masks[i] |= 1 << (c - 'a');
            indices.put(masks[i], i);
            uf[i] = i;
        };
        for (int i = 0; i < n; i++) {
            int mask = masks[i];
            for (int j = 0; j < 26; j++) {
                int num = (mask & 1 << j) == 0 ? mask + (1 << j) : mask - (1 << j);
                if (indices.containsKey(num)) uf[find(i, uf)] = uf[find(indices.get(num), uf)];
            }
            for (int j = 0; j < 26; j++) 
                if ((mask & 1 << j) > 0) 
                    for (int k = 0; k < 26; k++) 
                        if (k == j || (mask & 1 << k) == 0) {
                            int num = mask - (1 << j) + (1 << k);
                            if (indices.containsKey(num)) 
                                uf[find(i, uf)] = uf[find(indices.get(num), uf)];
                        }
        }
        for (int i = 0; i < n; i++) {
            find(i, uf);
            counts.put(uf[i], counts.getOrDefault(uf[i], 0) + 1);
            output = Math.max(counts.get(uf[i]), output);
        }
        return new int[] {counts.size(), output};
    }

    private int find(int i, int[] uf) {
        if (i == uf[i]) return i;
        return uf[i] = find(uf[i], uf);
    }
}