    //Time, O(NlogN), Space, O(1)
	public TreeNode sortedListToBST(ListNode head)
    {
		if(head == null) 
			return null;
		 return toBST(head,null);
    }
	
	public TreeNode toBST(ListNode head, ListNode tail)
	{
		ListNode slow = head;
		ListNode fast = head;
		if(head == tail) 
			return null;
		
		while(fast != tail && fast.next != tail)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		TreeNode thead = new TreeNode(slow.val);
		thead.left = toBST(head, slow);
		thead.right = toBST(slow.next, tail);
		return thead;
	}	
---------------------------------------------------------------------------------
Time, O(N), Space, O(N)
---------------------------------------------------------------------------------
class Solution 
{

  private List<Integer> values;

  public Solution() 
  {
     values = new ArrayList<Integer>();
  }

  private void mapListToValues(ListNode head)
  {
    while (head != null) 
	{      
	  values.add(head.val);
      head = head.next;
    }
  }

  private TreeNode convertListToBST(int left, int right) 
  {    	
    if (left > right) {
      return null;
    }

    int mid = (left + right) / 2;
    TreeNode node = new TreeNode(this.values.get(mid));
    
    if (left == right) 
	{
      return node;
    }
   
    node.left = convertListToBST(left, mid - 1);
    node.right = convertListToBST(mid + 1, right);
    return node;
  }

  public TreeNode sortedListToBST(ListNode head)
  {   
    mapListToValues(head);
    return convertListToBST(0, this.values.size() - 1);
  }
}