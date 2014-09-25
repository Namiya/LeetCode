import java.util.ArrayList;
import java.util.List;


public class KthLagestNums {
	List<Integer> maxList= new ArrayList<Integer>();
	List<Integer> maxinumGroup(List<Integer> list, int k)
	{
		if(list == null) return maxList;
		if(k == 0) return maxList;
		
		sortList(list, k);
		
		return maxList;
	}
	
	void sortList(List<Integer> list, int k)
	{
		if(k == 0) return;
		
		int val = list.get(0);
		List<Integer> leftList = new ArrayList<Integer>();
		List<Integer> rightList = new ArrayList<Integer>();
		int left = 0;
		int right = 0;
		for(int i = 1; i<list.size(); i++){
			if(list.get(i)<val){
				leftList.add(list.get(i));
				left++;
			}
			if(list.get(i) >= val){
				rightList.add(list.get(i));
				right++;
			}
		}
		
		if(right == k){
			maxList.addAll(rightList);
			return;
		}
		
		if(right > k){
			sortList(rightList, k);
			return;
		}
		
		if(right < k){
			maxList.addAll(rightList);
			maxList.add(val);
			k = k-right-1;
			
			sortList(leftList, k);
			return;
		}
	}
}
