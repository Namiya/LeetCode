
public class ConvertSortedArrayToBinarySearchTree {

	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

	public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) return null;
        if (num.length == 0) return null;
     
       	return generateTree(num, 0, num.length-1);
    }
	
	private TreeNode generateTree(int[] num, int start, int end)
	{
		if(start > end) return null;
	
		int index = start + (end-start)/2;
        
		TreeNode root = new TreeNode(num[index]);
        root.left = generateTree(num, start, index-1);
        root.right = generateTree(num, index+1, end);
        
        return root;
	}
}
