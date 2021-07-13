class LRUCache {

    int capacity = 0;
    Node head = null;
    Node tail = null;
    
    Map<Integer, Node> map = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        
        head.next = tail;
        tail.prev = head; 
        
        map = new HashMap();
    }
    
    public int get(int key) 
    {
        if(!map.containsKey(key))
            return -1;
        
        Node temp = map.get(key);
        removeNode(temp);
        addHead(temp);
        
        return temp.val;
    }
    
    public void put(int key, int value) 
	{        
        if(map.containsKey(key))
        {
            get(key);
            map.get(key).val = value;
        }
        else
        {
            Node newNode = new Node(key, value);
            if(map.size() == capacity)
            {        
                int keyToRemove = tail.prev.key;                                    
                removeNode(tail.prev); 
                map.remove(keyToRemove);  
            }
            
            addHead(newNode);
            map.put(key, newNode);            
        }
    }
    
    
    private void addHead(Node node)
    {
       node.next = head.next;    
       head.next.prev = node;
        
       node.prev = head;
       head.next = node;
    }
    
    private void removeNode(Node node){
        
        node.next.prev = node.prev;
        node.prev.next = node.next;        
    }
    
    class Node
    {        
        public  Node prev;
        public  Node next;
        public  int key;
        public  int val = -1;
        public  Node(int key, int val)
        {
            this.key = key;
            this.val = val;    
        }
    }
}
