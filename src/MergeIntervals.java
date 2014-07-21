import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MergeIntervals {
	//Definition for an interval.
	 public class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	 }
 
	 public List<Interval> merge(List<Interval> intervals) {
		 List <Interval> mergedList = new ArrayList<Interval>();
		if (intervals == null) return mergedList;
		if (intervals.isEmpty()) return mergedList;
		
       
        for (Interval interval: intervals)
        {
        	 insertInterval(interval);
        }
        
        Object[] startList = mapIntervals.keySet().toArray();
        Arrays.sort(startList);
        Interval interval1 = null, interval2 = null;
        for(Object key : startList)
        {
        	interval1 = mapIntervals.get(key);
        	if (isOverlap(interval1, interval2))
        	{
        		interval2 = mergeIntervals(interval1, interval2);
        	}
        	else
        	{
        		mergedList.add(interval2);
        		interval2 = interval1;
        	}    		
        }
        mergedList.add(interval2);
        
        return mergedList;
    }
	 
	 Map<Integer, Interval> mapIntervals = new HashMap<Integer, Interval>();
	 private void insertInterval (Interval interval)
	 {
		 if (mapIntervals.containsKey(interval.start))
		 {
			 Interval intervalInMap = mapIntervals.get(interval.start);
			 if (interval.end > intervalInMap.end)
				 mapIntervals.put(interval.start, interval);
		 }
		 else
		 {
			 mapIntervals.put(interval.start, interval);
		 }
	 }
	 
	 private Interval mergeIntervals(Interval interval1, Interval interval2)
	 {
		 if (interval1 == null) return interval2;
		 if (interval2 == null) return interval1;
		 
		 Interval interval = new Interval();
		 interval.start = (interval1.start < interval2.start) ? interval1.start : interval2.start;
		 interval.end = (interval1.end > interval2.end) ? interval1.end : interval2.end;
		 return interval;
	 }
	 
	 private boolean isOverlap(Interval interval1, Interval interval2)
	 {
		 if (interval1 == null) return true;
		 if (interval2 == null) return true;
		 
		 if (interval1.start > interval2.end) return false;
		 
		 if (interval1.end < interval2.start) return false;
		 
		
		 return true;
	 }
	 
	/*
	 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
	 * You may assume that the intervals were initially sorted according to their start times.
	 */
	    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    	List <Interval> mergedList = new ArrayList<Interval>();
	    	
	    	if (newInterval == null) return intervals;
	    	if ((intervals == null)	|| (intervals.isEmpty()))
	    	{
	    		mergedList.add(newInterval);
	    		return mergedList;
	    	}
	    	
	    	boolean insertFlag = false;
	        for ( Interval interval : intervals)
	        {
	        	if (isOverlap(interval, newInterval))
	        	{
	        		newInterval = mergeIntervals(interval, newInterval);
	        	}
	        	else
	        	{
	        		if ((insertFlag == false) && (newInterval.start < interval.start))
	        		{
	        			mergedList.add(newInterval);
	        			insertFlag = true;
	        		}
	        		mergedList.add(interval);
	        	}
	        }
	        if (insertFlag == false)
	        	mergedList.add(newInterval);
	        
	        return mergedList;
	    }
}
