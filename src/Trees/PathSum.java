/*
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

package Trees;

public class PathSum {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean leftSum=false,rightSum=false;

	public boolean hasPathSum(TreeNode root, int sum) {
		boolean result=hasPath(root,sum,0);
		return result;
	}

	public boolean hasPath(TreeNode root, int sum, int currentSum) {
		if(root==null)
			return false;

		currentSum=currentSum+root.val;

		if(currentSum==sum)
		{
			if(root.left==null && root.right==null)
				return true;
		}

		if(root.left!=null)
			leftSum= hasPath(root.left,sum,currentSum);

		if(root.right!=null)
			rightSum= hasPath(root.right,sum,currentSum);

		if(leftSum||rightSum)
			return true;

		return false;
	}
}
