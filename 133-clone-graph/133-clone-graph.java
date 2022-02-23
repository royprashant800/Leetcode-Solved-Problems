/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node src) {
        if(src == null) return src;
        Queue<Node> q = new LinkedList<>();
		q.add(src);
		
		HashMap<Node, Node> hm = new HashMap<>();
		hm.put(src, new Node(src.val));
		
		while(!q.isEmpty()) {
			Node u = q.poll();
			Node clonenodeU = hm.get(u);
			
			if(u.neighbors != null) {
				List<Node> v = u.neighbors;
				for(Node node : v ) {
					
					Node clonenodeG = hm.get(node);
					if(clonenodeG == null) {
						q.add(node);
						clonenodeG = new Node(node.val);
						hm.put(node, clonenodeG);
					}
					clonenodeU.neighbors.add(clonenodeG);
				}
			}
		}
		return hm.get(src);        
    }
}