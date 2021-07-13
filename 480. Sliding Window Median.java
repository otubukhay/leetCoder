class Solution
{
    public double[] medianSlidingWindow(int[] nums, int k) 
    {
        TreeSet<Integer> left = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[b], nums[a]) : a - b); //descending order
        TreeSet<Integer> right = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b); // ascending order

        for(int i = 0; i < k; i++) //
        {
            left.add(i);
        }
         
        balance(left, right);
		
        int index = 0;
        double[] result = new double[nums.length - k + 1];
        result[index++] = getMedian(left, right, nums, k);
        
        for(int i = k; i < nums.length; i++) 
        {           
            if(left.contains(i - k)) 
            {
                left.remove(i - k);                
                right.add(i); 
                left.add(right.pollFirst());
            }
            else
            {
                right.remove(i - k); 
                left.add(i); 
                right.add(left.pollFirst());
            } 
          
            balance(left, right); 
            result[index++] = getMedian(left, right, nums, k);
        }

        return result;
    }    
   
    void balance(TreeSet<Integer> left, TreeSet<Integer> right)
    {
        while(left.size() > right.size()) 
        {
            right.add(left.pollFirst()); 
        }
    }
    
    double getMedian(TreeSet<Integer> left, TreeSet<Integer> right, int[] nums, int k)
    {
       if(k % 2 == 0) 
       {
           return ((double) nums[left.first()] + nums[right.first()]) / 2 ;
       }
       else 
       {
           return (double) nums[right.first()];           
       }
    }    
}