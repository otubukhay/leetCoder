 public int mincostTickets(int[] days, int[] costs) {                    
          
          Set<Integer> s = new HashSet<>();
          for(int day : days){
              s.add(day);
          }
          
          int[] dp = new int[days[days.length - 1] + 1];
          dp[0] = 0;
          
          for (int i = 1; i < dp.length; i++) 
          {
            
            if (!s.contains(i))
            {
                dp[i] = dp[i - 1];
            }
            else
            {
                int oneDayTicket = dp[i - 1] + costs[0];
                int sevenDayTicket = dp[Math.max(0, i - 7)] + costs[1];
                int thirtyDayTicket = dp[Math.max(0, i - 30)] + costs[2];
                
                dp[i] = Math.min(oneDayTicket, Math.min(sevenDayTicket, thirtyDayTicket));                
            }
              
          }
        
          return dp[dp.length - 1];
    }