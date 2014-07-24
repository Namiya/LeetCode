
public class MinimumDepthofBinaryTree {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	private int minLen = 0;
	public int minDepth(TreeNode root) {
      
		getMinDepth(root, 0);
		
		return minLen;
		
    }
	
	private void getMinDepth(TreeNode root, int len){
		if (root == null) return ;
		
		len++;
		getMinDepth(root.left,len);
		getDepth(root, len);
		getMinDepth(root.right, len);
		getDepth(root, len);		
	}
	
	private void getDepth(TreeNode node, int len)
	{
		if ((node.left == null) && (node.right == null))
			if ((minLen == 0) || (minLen > len))  minLen = len;
	}
}
