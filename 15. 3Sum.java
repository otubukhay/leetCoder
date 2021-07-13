public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);        
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;
     
        for(int i = 0; i < n - 2 ;i++)
        {          
              if(i > 0 && nums[i - 1] == nums[i])
                  continue;

              int j = i + 1; 
              int k = n - 1;

              while(j < k)
              {
                  int sum = nums[i] + nums[j] + nums[k];
                  if(sum == 0)
                  {
                      List<Integer> cur = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                      
                      result.add(cur);         
                      j++;
                      k--;
                      
                      while(j < k && nums[j] == nums[j - 1])
                      {
                          j++;                  
                      }

                      while(j < k && nums[k] == nums[k + 1])
                      {
                         k--;                  
                      }

                  }
                  else if(sum > 0)
                  {
                      k--;
                  }
                  else
                  {
                      j++;              
                  }
              }         

          }

            return result;
    }