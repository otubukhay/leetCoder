***************************************************************************************
131. Palindrome Partitioning
***************************************************************************************

    public List<List<String>> partition(String s) 
    {
       List<List<String>> res = new ArrayList<List<String>>();
       List<String> list = new ArrayList<String>();
       dfs(s,0,list,res);
       return res;      
    }
    
    public void dfs(String s, int pos, List<String> list, List<List<String>> res)
    {
        if(pos == s.length()) 
        {
            res.add(new ArrayList<String>(list));
        }
        else
        {
            for(int i = pos; i < s.length(); i++)
            {
                if(isPal(s, pos, i))
                {
                    list.add(s.substring(pos, i + 1));
                    dfs(s, i + 1, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    
    public boolean isPal(String s, int low, int high){
        while(low < high) 
            if(s.charAt(low++) != s.charAt(high--)) 
                return false;
        return true;
    }
	
************************************************************************************
140. Word Break II
************************************************************************************
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, List<String> wordDict) 
    {
        return wordBreak(s, new HashSet<String>(wordDict));
    }    
    
    public List<String> wordBreak(String str, Set<String> wordDict) 
    {
        List<String> res = new ArrayList<String>();  
        if(map.containsKey(str)) 
        {
            return map.get(str);
        }
        
        if(wordDict.contains(str)) 
        {
            res.add(str);
        }
        
        for(int i = 1; i < str.length(); i++) 
        {
            String firstPart = str.substring(0, i);
            if(wordDict.contains(firstPart)) 
            {               
                for(String secondPart : wordBreak(str.substring(i), wordDict)) 
                {
                    res.add(firstPart + " " + secondPart);
                }
            }
        }
        
        map.put(str, res);
        return res;
    }
	
*******************************************************************************
698. Partition to K Equal Sum Subsets
*******************************************************************************

public boolean canPartitionKSubsets(int[] nums, int k) 
    {
        int sum = 0;        
        for(int num : nums)
            sum += num;
        
        if((sum % k) != 0)
            return false;
        
        return find(nums, 0, new boolean[nums.length], 0, k, sum/k, 0);
    }
    
    boolean find(int[] nums, int curSum, boolean[] visited, int bucket, int k, int expectedSum, int index)
    {
        if(bucket == k - 1 && curSum == expectedSum)
        {
            return true;
        }  
        
        if(curSum > expectedSum)
		{
            return false;
		}
        
        if(curSum == expectedSum)
        {
           return find(nums, 0, visited, bucket + 1, k, expectedSum, 0);    
        } 
        else
        {
            for(int i = index; i < nums.length; i++)
            {            
                if(!visited[i])
                {
                   visited[i] = true;                    
                   if(find(nums, curSum + nums[i], visited, bucket, k, expectedSum, i + 1))
                   {
                      return true;    
                   }
                   visited[i] = false;
                }
            }     
            
            return false;
        }     
        
        
    }