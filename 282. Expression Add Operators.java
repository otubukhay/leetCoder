/*This problem has a lot of edge cases to be considered:

Overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too. 105323 ... stop at , when pos = 1, and  i = 2,break
a little trick is that we should save the value that is to be multiplied in the next recursion.
*/
//Time - there are n - 1 slots for us to add an operator and there are 4 choices (+, -, * and no operator) 
//so the complexity is O(4^(N-1)) * N).
    public class Solution
    {
    
        public List<String> addOperators(String num, int target) 
        {
            List<String> rst = new ArrayList<String>();           
            helper(rst, "", num, target, 0, 0, 0);
            return rst;
        }


        public void helper(List<String> rst, String path, String num, int target, int pos, long onGoingResult, long previousValue)
        {
            if(pos == num.length())
            {
                if(target == onGoingResult)
                {
                    rst.add(path);
                }                
            }
            else
            {
                for(int i = pos; i < num.length(); i++) 
                {
					/*
					Input
					num = "105"
					target = 5

					My Output - ["1*0+5","1*5","10-5"]
					Expected - ["1*0+5","10-5"]
					*/
					
                    if(i != pos && num.charAt(pos) == '0') // Try test above
                        break;

                    long cur = Long.parseLong(num.substring(pos, i + 1));
                    if(path.length() == 0)
                    {
                        helper(rst, path + cur, num, target, i + 1, cur, cur);
                    }
                    else
                    {
                        helper(rst, path + "+" + cur, num, target, i + 1, onGoingResult + cur, cur);

                        helper(rst, path + "-" + cur, num, target, i + 1, onGoingResult - cur, -cur);

                        helper(rst, path + "*" + cur, num, target, i + 1, onGoingResult - previousValue + previousValue * cur, previousValue * cur);
                    }
                }    
            }
           
        }
    }