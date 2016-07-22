/*
 *  Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */

package Trees;

public class FlattenBinaryTree {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public void flatten(TreeNode root) {
		if(root==null)
			return;

		TreeNode current=root;

		while(current!=null)
		{
			if(current.left!=null)
			{
				if(current.right!=null)
				{
					TreeNode next=current.left;
					while(next.right!=null) 
						next=next.right;

					next.right=current.right;
				}

				current.right=current.left;
				current.left=null;

			}
			current=current.right;
		}
	}
}
