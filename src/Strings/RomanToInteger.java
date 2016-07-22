/*
 * Given a roman numeral, convert it to an integer.
	Input is guaranteed to be within the range from 1 to 3999.
*/

package Strings;

public class RomanToInteger {

	public int romanToInt(String a) {
		if(a==null)
			return 0;

		int result=0,curr=0;
		int prev=0;


		for(int i=0;i<a.length();i++)
		{
			curr=romanTable(a.charAt(i));

			if(curr>prev)
				result=result+(curr-(prev*2));
			else
				result=result+curr;

			prev=curr;
		}

		return result;

	} //function ends here

	public static int romanTable(char c){
		switch (c) {

		case 'I': return 1;

		case 'V': return 5;

		case 'X': return 10;

		case 'L': return 50;

		case 'C': return 100;

		case 'D': return 500;

		case 'M': return 1000;

		default: return 0;

		}
	}
}
