class LRUCache 
{
    int capacity = 0;    
    Map<Integer, Node> cache = null;
    Node head = null;
    Node tail = null;
    
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        
        head.next = tail;
        tail.prev = head;
        
        cache = new HashMap();
    }
    
    public int get(int key) 
    {
        if(!cache.containsKey(key))
            return -1;
        
        Node temp = cache.get(key);       
        removeNode(temp);
        addHead(temp);
        
        return temp.val;
    }
    
    public void put(int key, int value) 
    {
        if(cache.containsKey(key))
        {           
           get(key);                               
            cache.get(key).val = value; 
        }
        else
        {
            Node newNode = new Node(key, value);
            if(cache.size() == capacity)
            {                      
               cache.remove(tail.prev.key);                   
               removeNode(tail.prev);                                
            }
            
            addHead(newNode);
            cache.put(key,  newNode);
        }
    }
    
    private void removeNode(Node temp)
    {            
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
    }
    
    private void addHead(Node node)
    {
        node.next = head.next;
        head.next.prev = node;
        
        head.next = node;
        node.prev = head;
    }
}

class Node 
{    
    public Node next;
    public Node prev;
    public int val;
    public int key;
    
   
    public Node(int key, int val)
    {
        this.key = key;
        this.val = val;
    }    
    
    public Node(Node next, Node prev, int val)
    {
        this.next = next;
        this.val = val;
        this.prev = prev;
    }
}
