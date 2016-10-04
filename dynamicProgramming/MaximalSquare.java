/*
https://leetcode.com/problems/maximal-square/


Solution reference:  https://discuss.leetcode.com/topic/15328/easy-dp-solution-in-c-with-detailed-explanations-8ms-o-n-2-time-and-o-n-space


Well, this problem desires for the use of dynamic programming. They key to any DP problem is to come up with the state equation. In this problem, we define the state to be the maximal size of the square that can be achieved at point (i, j), denoted as P[i][j]. Remember that we use size instead of square as the state (square = size^2).

Now let's try to come up with the formula for P[i][j].

First, it is obvious that for the topmost row (i = 0) and the leftmost column (j = 0), P[i][j] = matrix[i][j]. This is easily understood. Let's suppose that the topmost row of matrix is like [1, 0, 0, 1]. Then we can immediately know that the first and last point can be a square of size 1 while the two middle points cannot make any square, giving a size of 0. Thus, P = [1, 0, 0, 1], which is the same as matrix. The case is similar for the leftmost column. Till now, the boundary conditions of this DP problem are solved.

Let's move to the more general case for P[i][j] in which i > 0 and j > 0. First of all, let's see another simple case in which matrix[i][j] = 0. It is obvious that P[i][j] = 0 too. Why? Well, since matrix[i][j] = 0, no square will contain matrix[i][j]. According to our definition of P[i][j], P[i][j] is also 0.

Now we are almost done. The only unsolved case is matrix[i][j] = 1. Let's see an example.

Suppose matrix = [[0, 1], [1, 1]], it is obvious that P[0][0] = 0, P[0][1] = P[1][0] = 1, what about P[1][1]? Well, to give a square of size larger than 1 in P[1][1], all of its three neighbors (left, up, left-up) should be non-zero, right? In this case, the left-up neighbor P[0][0] = 0, so P[1][1] can only be 1, which means that it contains the square of itself.

Now you are near the solution. In fact, P[i][j] = min(P[i - 1][j], P[i][j - 1], P[i - 1][j - 1]) + 1 in this case.

Taking all these together, we have the following state equations.

P[0][j] = matrix[0][j] (topmost row);
P[i][0] = matrix[i][0] (leftmost column);
For i > 0 and j > 0: if matrix[i][j] = 0, P[i][j] = 0; if matrix[i][j] = 1, P[i][j] = min(P[i - 1][j], P[i][j - 1], P[i - 1][j - 1]) + 1.
Putting them into codes, and maintain a variable maxsize to record the maximum size of the square we have seen, we have the following (unoptimized) solution.
*/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix.length==0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int max = 0;
        
         //初始化 第1行 和第1列的数字
        for (int i = 0; i < row; i++){
            if (matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = 1;
            }
        }        
         
        for (int j = 0; j < col; j++){
            if (matrix[0][j] == '1'){
                dp[0][j] = 1;
                max = 1;
            }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max * max;
        
    }
}
