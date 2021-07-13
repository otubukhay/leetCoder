public class MovingAverage {
  
    /*
     * @param val: An integer
     * @return:  
     */
    double sum;
    int size;
    List<Integer> list;
 
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.list = new ArrayList<>();
        this.size = size;
    }
 
    public double next(int val) {
        sum += val;
        list.add(val);
 
        if(list.size() > size){
            int head = list.remove(0);
            sum = sum - head;
        }
      
        return sum/list.size();
    }
}