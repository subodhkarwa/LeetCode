/*
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]. 

 */
package Arrays;

public class MoveZeroToEnd {
	public void moveZeroes(int[] nums) {
		int current=0;

		if(nums==null || nums.length<2)
			return;

		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]!=0)
				nums[current++]=nums[i];
		}

		while(current<nums.length)
			nums[current++]=0;
	}
}
