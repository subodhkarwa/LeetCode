/*
 *  You are given coins of different denominations and a total amount of money amount. 
 *  Write a function to compute the fewest number of coins that you need to make up that amount.
 *   If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin. 
 */

package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		if(amount<=0)
			return 0;

		else
		{
			int[] sum= new int[amount+1];
			Arrays.fill(sum,Integer.MAX_VALUE-1000);

			sum[0]=0;                
			for(int i=0;i<=amount;i++)
			{
				for(int j=0;j<coins.length;j++)
				{
					if(coins[j] <=i )  
						sum[i]=Math.min(1+sum[i-coins[j]],sum[i]);
				}
			}   

			if(sum[amount]>=Integer.MAX_VALUE-1000)
				return -1;

			return sum[amount];
		}

	}


}
