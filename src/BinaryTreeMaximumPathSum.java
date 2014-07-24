
public class BinaryTreeMaximumPathSum {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	private int max = 0;
	
	public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        
        max = root.val;
        pathSum(root);
        
        return max;
    }

	private int pathSum(TreeNode root)
	{   
		if (root == null) return 0;

		
        int left = pathSum(root.left);
        int right = pathSum(root.right);
        int val=0;
        int subTreeVal = 0;
        if ((left<=0) && (right <= 0))
        {
        	val = root.val; 
        	subTreeVal = root.val;
        }
        else 
        {
        	val = (root.val+left) > (root.val+right) ? (root.val+left) : (root.val+right);
        	subTreeVal = val > (root.val+left+right) ? val : (root.val+left+right);
        }
        	
        max = max > subTreeVal ? max : subTreeVal;
        return val;        
	}

}
