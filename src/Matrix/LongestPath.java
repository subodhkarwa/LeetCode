/*
 * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]

Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]

Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 */

package Matrix;

public class LongestPath {

	private static int[] dx={0,0,-1,1};
	private static int[] dy={-1,1,0,0};

	public static int longestIncreasingPath(int[][] matrix) {

		if(matrix.length==0)
			return 0;

		int rows=matrix.length;
		int cols=matrix[0].length;

		int[][] distance=new int[rows][cols];

		int longest=0;

		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
			{
				distance[i][j]=Math.max(distance[i][j],getMaxNeighbours(i,j,rows,cols,matrix,distance));

				if(distance[i][j]>longest)
					longest = distance[i][j];
			}
		return longest;
	}


	private static int getMaxNeighbours(int i, int j, int rows, int cols,
			int[][] matrix, int[][] distance) {

		if(distance[i][j]!=0)
			return distance[i][j];

		for(int k=0;k<4;k++)
		{
			int newX= i + dx[k];
			int newY= j + dy[k];

			if((newX>=0 && newX <rows) && (newY >=0 && newY <cols) && (matrix[newX][newY] > matrix[i][j]))
				distance[i][j]=Math.max(distance[i][j],getMaxNeighbours(newX,newY, rows, cols, matrix, distance));			
		}

		return ++distance[i][j];
	}
}
