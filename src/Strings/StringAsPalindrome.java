/*
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome. 
 */
package Strings;

public class StringAsPalindrome {

	public  boolean isPalindrome(String s) {

		s=getModifiedString(s);

		if(s==null || s.length()<2)
			return true;

		int begining=0;
		int ending=s.length()-1;

		while(begining<=ending)
		{ 
			if(s.charAt(begining)==s.charAt(ending))
			{
				begining++;
				ending--;
			}
			else	
				return false;
		}
		return true;
	}


	private String getModifiedString(String input) {

		StringBuffer result=new StringBuffer();

		if(input==null)
			return null;

		for(int i=0;i<input.length();i++)
		{
			char c=Character.toLowerCase(input.charAt(i));
			if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') )
				result.append(c);
		}

		return result.toString();		
	}


}
