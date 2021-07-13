class Solution 
{
    public int minArea(char[][] image, int x, int y) 
	{          
        int m = image.length;
        int n = image[0].length;
        
        int leftX = findXFarthest(0, y, image, true);
        int rightX = findXFarthest(y, n - 1, image, false);
        
        int upY = findYFarthest(0, x, image, true);
        int downY = findYFarthest(x, m - 1, image, false);
        
        return (rightX - leftX + 1) * (downY - upY + 1);
    }
    
    int findYFarthest(int lo, int hi, char[][] image, boolean up) 
    {
         int index = -1;
         while(lo <= hi)
         {
             int mid = lo + (hi - lo)/2;
             if(findY(mid, image))
             {
                 index = mid;
                 if(up)
                 {
                    hi = mid - 1;                
                 }
                 else
                 {
                    lo = mid + 1;         
                 }
             }
             else
             {                 
                 if(up)
                 {
                    lo = mid + 1;           
                 }
                 else
                 {
                     hi = mid - 1;        
                 }
             }
         }
        
         return index;
    }   
   
    
    boolean findY(int row, char[][] img)
    {
        for(int i = 0; i < img[0].length; i++)    
        {
            if(img[row][i] == '1')
                return true;              
        }
        
        return false;
    }
    
    
    int findXFarthest(int lo, int hi, char[][] image, boolean left) 
    {
         int index = -1;
         while(lo <= hi)
         {
             int mid = lo + (hi - lo)/2;
             if(findX(mid, image))
             {
                 index = mid;
                 if(left)
                 {
                    hi = mid - 1;
                 }
                 else
                 {
                    lo = mid + 1; 
                 }
             }
             else
             {
                 if(left)
                 {
                    lo = mid + 1;
                 }
                 else
                 {
                     hi = mid - 1; 
                 }
             }
         }
        
         return index;
    }    
  
    boolean findX(int col, char[][] img)
    {
        for(int i = 0; i < img.length; i++)    
        {
            if(img[i][col] == '1')
                return true;              
        }
        
        return false;
    }
}