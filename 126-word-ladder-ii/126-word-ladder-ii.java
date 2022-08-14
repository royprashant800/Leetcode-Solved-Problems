class Solution {

    private final List<List<String>> result = new ArrayList<>();
    private final List<String> runningDFSPath = new LinkedList<>();
    private Set<String> visitedDuringDFS = new HashSet<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) {
            return List.of();
        }

        Map<String, List<String>> adjacency = buildAdjacency(beginWord, endWord, dictionary);
        findAllPaths(beginWord, endWord, adjacency);
        return result;
    }

    private void findAllPaths(String beginWord, String endWord, Map<String, List<String>> adjacencies) {
        if (visitedDuringDFS.contains(beginWord)) {
            return;
        }
        if (beginWord.equals(endWord)) {
            runningDFSPath.add(endWord);
            result.add(new ArrayList<>(runningDFSPath));
            runningDFSPath.remove(endWord);
            visitedDuringDFS = new HashSet<>();
            return;
        }
        List<String> adj = adjacencies.get(beginWord);
        if (adj == null || adj.isEmpty()) {
            return;
        }
        visitedDuringDFS.add(beginWord);
        for (String adjWord : adj) {
            runningDFSPath.add(beginWord);
            findAllPaths(adjWord, endWord, adjacencies);
            runningDFSPath.remove(beginWord);
        }
    }

    private Map<String, List<String>> buildAdjacency(String beginWord, String endWord, Set<String> dictionary) {
        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.add(beginWord);
        dictionary.remove(beginWord);
        Map<String, List<String>> adjacencies = new HashMap<>();
        Set<String> wasInTheQueue = new HashSet<>();
        boolean endWordFound = false;
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            Set<String> visited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> adj = new ArrayList<>();
                String word = bfsQueue.poll();

                for (int j = 0; j < word.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        char[] arr = word.toCharArray();
                        if (arr[j] == k) {
                            continue;
                        }
                        arr[j] = k;

                        String str = new String(arr);
                        if (dictionary.contains(str)) {
                            adj.add(str);
                            if (!wasInTheQueue.contains(str)) {
                                bfsQueue.add(str);
                                wasInTheQueue.add(str);
                            }
                            visited.add(str);

                            if (str.equals(endWord)) {
                                endWordFound = true;
                            }
                        }
                    }
                }
                adjacencies.put(word, adj);
            }
            if (endWordFound) {
                break;
            }
            dictionary.removeAll(visited);
        }
        return adjacencies;
    }
}