/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.

 */

package Matrix;

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        
        int start=0;
        int end=matrix.length*matrix[0].length-1;
        
        while(start<=end)
        {
            
            int mid=start+(end-start)/2;
            
            int candidate=matrix[mid/matrix[0].length][mid%matrix[0].length];
            
            if(candidate==target)
                return true;
                
            else if(candidate > target)
                 end=mid-1;
            else
                 start=mid+1;
            
        }
        return false;
        
    }
}
