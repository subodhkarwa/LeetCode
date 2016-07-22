/*
 *  Implement strStr().
	Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
*/
package Strings;

public class StrStr {

    public int strStr(String haystack, String needle) {
        if(needle==null || haystack==null)
   	        return -1;

           int needleLength=needle.length();
           int haystackLength=haystack.length();
           
           if(needleLength > haystackLength)
               return -1;
               
           for(int i=0;i<=(haystackLength-needleLength);i++)
           {
               if(haystack.substring(i,i+needleLength).equals(needle))
                   return i;
           }
           return -1;
       }
}
