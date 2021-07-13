 public static int readOne(char[] buf, int n)
 {
        char[] dataRead = new char[4];
        int total = 0;
        while(total < n) 
		{
            int dataReadCount = 0;
            int dataReadIndex = 0;
            dataReadCount = read4(dataRead);
            
            while(total < n && dataReadIndex < dataReadCount) 
            {
                buf[total++] = dataRead[dataReadIndex++];
            }

            if(dataReadCount < 4) 
            {
                break;
            }
        }

        return total;
    }