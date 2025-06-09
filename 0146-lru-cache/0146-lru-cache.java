class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.get(key) == null) return -1;
        Node node = map.get(key);
        deleteNode(node);
        insertNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            deleteNode(map.get(key));
        } else {
            if(map.size() == capacity) deleteNode(tail.prev);
        }
        insertNode(new Node(key, value));
    }
    private void deleteNode(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insertNode(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
class Node {
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */