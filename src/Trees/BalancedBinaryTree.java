/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
 */
package Trees;

public class BalancedBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

		public boolean isBalanced(TreeNode a) {
			if(a==null)
				return true;

			int lHeight=height(a.left);
			int rHeight=height(a.right);

			if ((Math.abs(lHeight - rHeight) <= 1) && isBalanced(a.left) && isBalanced(a.right))
				return true;

			return false;
		}

		public int height(TreeNode a)
		{
			if(a==null)
				return 0;

			return 1+ Math.max(height(a.left),height(a.right));
		}

	}
