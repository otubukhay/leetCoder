public class Solution extends Reader4 
{  
    private int dataReadCount;
    private int dataReadIndex;
    private char[] tmp = new char[4];
    
	public int read(char[] buf, int n)
	{
        int total = 0;
        while (total < n) 
		{
            if (dataReadIndex == 0) {
                dataReadCount = read4(tmp);
            }

            while (total < n && dataReadIndex < dataReadCount) {
                buf[total++] = tmp[dataReadIndex++];
            }

            if(dataReadIndex == dataReadCount) 
				dataReadIndex = 0;
            
            if (dataReadCount < 4) 
				break;
           
        }

        return total;
    }
}