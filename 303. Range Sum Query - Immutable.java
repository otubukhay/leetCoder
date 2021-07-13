class NumArray {
  private int[] nums;
  
    public NumArray(int[] nums) {
   
       for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i - 1];
       }
    
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
       return (i > 0) ? nums[j] - nums[i - 1] : nums[j];
    }
}
