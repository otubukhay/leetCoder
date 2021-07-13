 public List<Interval> employeeFreeTime(List<List<Interval>> avails) 
    {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        avails.forEach(e -> pq.addAll(e));
        
        int lastEnd = pq.poll().end;
        while (!pq.isEmpty())
        {
            Interval current = pq.poll(); 
            if (lastEnd < current.start) 
            {
                result.add(new Interval(lastEnd, current.start));
                lastEnd = current.end;
            } 
            else 
            {
                lastEnd = Math.max(lastEnd, current.end);
            }
        }
        
        return result;
    }
