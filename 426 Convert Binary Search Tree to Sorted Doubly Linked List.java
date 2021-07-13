public class Solution 
{    
    TreeNode head = null;
    TreeNode prev = null;
    public TreeNode treeToDoublyList(TreeNode root) 
	{
        if(root == null)
            return null;

        fixLeft(root);
        fixRight(root);
		
        return head;
    }

    void fixRight(TreeNode root)
    {
        if(root == null)
            return;
        
        TreeNode cur = root;
        while(cur.right != null)
        {
            cur = cur.right;
        }
        
        TreeNode tail = cur;
        while(cur.left != null)
        {
            cur.left.right = cur;
            cur = cur.left;
        }      
         
        head.left = tail;
        tail.right = head;
    }

    void fixLeft(TreeNode root)
    {
        if(root == null)
            return;
        fixLeft(root.left);
        if(head == null)
        {
            head = root;
        }

        root.left = prev;
        prev = root;
        fixLeft(root.right);
    }
}
***********************************************************************************
***********************************************************************************
     public Node treeToDoublyList(Node root) 
     {
        if(root == null) 
            return root;
        
        Node dummy = new Node(0);
        Node prev = dummy;
        Stack<Node> stack = new Stack();
        Node curr = root;

        while(!stack.isEmpty()|| curr != null)
        {
            if(curr!= null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                curr = stack.pop();
                prev.right = curr;
                curr.left = prev;
                prev = curr;
                curr = curr.right;                
            }           
        }
         
        dummy.right.left = prev;
        prev.right = dummy.right;
        return dummy.right;
    }