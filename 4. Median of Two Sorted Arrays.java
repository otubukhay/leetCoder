class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        return find(A, B);
    }
    
    public double find(int input1[], int input2[]) 
    {        
        if (input1.length > input2.length) 
        {
            return findMedianSortedArrays(input2, input1);
        }
        
        int lengthX = input1.length;
        int lengthY = input2.length;        
        int totalElement = lengthX + lengthY;

        int low = 0;
        int high = lengthX;
        while (low <= high) 
        {
            int partitionX = (low + high)/2;
            int partitionY = (totalElement + 1)/2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == lengthX) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == lengthY) ? Integer.MAX_VALUE : input2[partitionY];
           
            if (maxLeftX > minRightY) 
            {
                high = partitionX - 1;
            } 
            else if(maxLeftY > minRightX)
            { 
                low = partitionX + 1;
            }
            else
            {
                if ((totalElement) % 2 == 0) 
                {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } 
                else 
                {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }
        }

       return 0.0;
    }

}