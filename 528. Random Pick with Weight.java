class Solution {

       int[] sums = null;
    public Solution(int[] w)
    {
        sums = new int[w.length];
        sums[0] = w[0];
        for(int i = 1; i < w.length; i++)
        {
           sums[i] = sums[i - 1] + w[i];
        }
    }
    
    public int pickIndex() 
    {
        Random randomGenerator = new Random();
        int num = randomGenerator.nextInt(sums[sums.length - 1]) + 1;
        int index = Arrays.binarySearch(sums, num);
        return (index >= 0 && index < sums.length) ? index : Math.abs(index) - 1;
    }    

}