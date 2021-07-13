public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> queue = new LinkedList();    
    public NestedIterator(List<NestedInteger> nestedList) {
            helper(nestedList);
    }
    
    private void helper(List<NestedInteger> list){
        if (list == null)
            return;
        
        for (NestedInteger in: list){
            if (in.isInteger())
                queue.offer(in.getInteger());
            else
            {
                helper(in.getList());
            }
            
        }
    }

    @Override
    public Integer next() {       
       return hasNext() ? queue.poll() : -1;
    }

    @Override
    public boolean hasNext() {       
            return !queue.isEmpty();       
    }

}