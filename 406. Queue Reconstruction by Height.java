public int[][] reconstructQueue(int[][] people) 
{
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);         
        List<int[]> list = new ArrayList<int[]>();      
        for(int[] person : people)
        {
            list.add(person[1], person);
        }  
     
        return list.toArray(new int[people.length][]);
}