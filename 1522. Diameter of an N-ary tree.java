    int maxGlobal = 0;
    public int diameter(Node root) 
    {
        findIt(root);
        return maxGlobal;
    }
    
    int findIt(Node root)
    {
          if(root == null)
             return 0;
          
          int largest = 0, secondLargest = 0;                              
          for(Node child : root.children)
          {
              int childDiameter = findIt(child);           
              if(childDiameter > largest)
              {
                  secondLargest = largest;
                  largest = childDiameter;
              }
              else if(childDiameter > secondLargest)
              {
                  secondLargest = childDiameter;
              }
          }

          maxGlobal = Math.max(maxGlobal, secondLargest + largest);
          return 1 + Math.max(largest, secondLargest);
    }