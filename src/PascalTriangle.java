import java.util.List;
import java.util.ArrayList;

public class PascalTriangle {
	List<List<Integer>> pList = new ArrayList<List<Integer>>();
	public List<List<Integer>> generate(int numRows) {
		if (numRows == 0) return pList;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if (numRows == 1) 
		{
			pList.add(list);
			return pList;
		}
		
		generate(numRows-1);
		
		
		List<Integer> upList = pList.get(numRows-2);
		for (int i=1; i<numRows-1; i++)
		{
			int num = upList.get(i-1) + upList.get(i);
			list.add(num);
		}
		list.add(1);
		pList.add(list);
		
		return pList;
        
    }

	/* Given an index k, return the kth row of the Pascal's triangle.
	 * use only O(k) extra space
	 */
	public List<Integer> getRow(int rowIndex) {
        List <Integer> list = new ArrayList<Integer>();
        list.add(1);
        if (rowIndex == 0)
        {
        	return list;
        }
        
        list.add(1);
        if (rowIndex == 1)
        {
        	return list;
        }
     
        List <Integer> newlist = list;
        List <Integer> tmplist = new ArrayList<Integer>();
        for (int i=2; i<=rowIndex; i++)
        {
        	list = tmplist;
        	tmplist = newlist; 
        	list.clear();
        	list.add(1);
        	for (int j=0; j<i-1; j++)
        	{
        		int num = tmplist.get(j) + tmplist.get(j+1);
        		list.add(num);
        	}
        	list.add(1);
        	newlist = list;   	
        }
        return list;
        
    }
}

/*
public static void main (String[] args) throws java.lang.Exception
{
	// your code goes here
    PascalTriangle pascal = new PascalTriangle();
    List<List<Integer>> pList = pascal.generate(0);
    for (List list: pList)
    {
    	System.out.println(list);
    }
    
    List list = pascal.getRow(3);
    System.out.println(list);
	
}
*/