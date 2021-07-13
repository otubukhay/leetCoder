    public int leastInterval(char[] tasks, int n) 
    {
        int[] counter = new int[26];
        int highestFrequency = 0;
        int numberOfTaskWithHighestFrequency = 0;
        for(char task : tasks) 
        {
            counter[task - 'A']++;
            if(counter[task - 'A'] > highestFrequency)
            {                
                highestFrequency = counter[task - 'A'];
                numberOfTaskWithHighestFrequency = 1;
            }
            else if(highestFrequency == counter[task - 'A']) 
            {
                numberOfTaskWithHighestFrequency++;
            }            
        }
        
        int slotParts = highestFrequency - 1;
        int slotsInEachPart = n - numberOfTaskWithHighestFrequency + 1;        
        int totalAvailableSlots = slotsInEachPart * slotParts;
        
        int pendingTasks = tasks.length - (numberOfTaskWithHighestFrequency * highestFrequency);
        
        int idleSlots =  Math.max(0, totalAvailableSlots - pendingTasks);            
        return idleSlots + tasks.length;            
    }