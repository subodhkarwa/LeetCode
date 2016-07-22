/*
 * 	Given a string, find the length of the longest substring without repeating characters.
	Examples:
	Given "abcabcbb", the answer is "abc", which the length is 3.
	Given "bbbbb", the answer is "b", with the length of 1.
	Given "pwwkew", the answer is "wke", with the length of 3.
	Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
 
package Strings;

public class LongestSubstringWithoutRepetation {

	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		int i = 0, j = 0;
		int maxLen = 0;
		boolean[] exist =new boolean[256];
		
		while (j < len) {
			if (exist[s.charAt(j)]) {
				maxLen = Math.max(maxLen, j-i);
				while (s.charAt(i) != s.charAt(j)) {
					exist[s.charAt(i)] = false;
					i++;
				}
				i++;
				j++;    
			} else {
				exist[s.charAt(j)] = true;
				j++;
			}
		}
		maxLen = Math.max(maxLen, len-i);
		return maxLen;
	}
	
}
