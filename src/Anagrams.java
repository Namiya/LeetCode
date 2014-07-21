import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Anagrams {
	
	
	public List<String> anagrams(String[] strs) {
		List <String> list = new ArrayList<String>();
		angStrInMap.clear();
		for (int index = 0; index < strs.length; index++)
		{
			String str = strs[index];
			String sorted = sortString(str);
			if (isAnagram(index, sorted))
			{
				list.add(str);
				
			}
		}
		
		for (int index : angStrInMap)
		{
			String str = strs[index];
			list.add(str);
		}
		
		return list;
        
    }
	
	
	private String sortString(String str)
	{
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		String sortedStr = new String(chars);
		return sortedStr;
	}
	
	private Map<String, Integer> strMap = new HashMap<String, Integer>();
	private List<Integer> angStrInMap = new ArrayList<Integer>();
	private boolean isAnagram(Integer index, String str)
	{
		if (strMap.containsKey(str))
		{
			int indexVal = strMap.get(str);
			if (!angStrInMap.contains(indexVal))
				angStrInMap.add(indexVal);
			return true;		
		}
			
		
		strMap.put(str, index);
		return false;
	}

}
