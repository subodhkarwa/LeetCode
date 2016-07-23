
/*
 *  Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"]. 

 */
package Arrays;

import java.util.LinkedList;
import java.util.List;

public class SummaryRange {


	public List<String> summaryRanges(int[] nums) {
		List<String> result= new LinkedList<String>();
		if(nums.length==0)    return result;

		if(nums.length==1)
		{
			result.add(nums[0]+"");
			return result;
		}

		int start=0;
		for(int i=0;i<nums.length;i++)
		{
			start=nums[i];        

			while((i<nums.length-1) && nums[i+1]==(nums[i]+1) )
				i++;

			if(start!=nums[i])
				result.add(new String(start+"->"+nums[i]));
			else
				result.add(new String(start+""));    
		}
		return result;
	}

}
