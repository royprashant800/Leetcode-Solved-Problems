class Solution {
    public Node connect(Node root) {
        return rightPointer(root);
    }
    static Node rightPointer(Node root) {
        Node temp = root;
		if(root == null)
			return null;
		root.next = null;
		
		while(root != null) {
			Node q = root;
			while(q != null) {
				if(q.left != null) {
					if(q.right != null) {
						q.left.next = q.right;
					} else {
						q.left.next = getNextRight(q);
					}
				} 
				if(q.right != null)
					q.right.next = getNextRight(q);
				
				q = q.next;
			}
			if(root.left != null)
				root = root.left;
			else if(root.right != null)
				root = root.right;
			else
				root = getNextRight(root);
		}
        return temp;
	}
    static Node getNextRight(Node root) {
		Node temp = root.next;
		
		while(temp != null) {
			if(temp.left != null) 
				return temp.left;
			if(temp.right != null) 
				return temp.right;
			
			temp = temp.next;  
		}
		return null;
	}
}