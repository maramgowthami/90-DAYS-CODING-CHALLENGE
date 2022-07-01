## Time Complexity:-o(n*m)
## Space Complexity:-O(m-1+n-1)+O(m*n)
class Solution {
    public int uniquePaths(int m, int n) 
    {
        int dp[][]=new int[m][n];
        return uniquePaths(0,0,m,n,dp);
    }
    
    public int uniquePaths(int i,int j,int m,int n,int dp[][])
    {
        
        if(i==m-1 && j==n-1)
        {
            return 1;
        }
        if(i>m-1|| j>n-1)
        {
            return 0;
        }
        if(dp[i][j]!=-0)
        {
            return dp[i][j];
        }
        int down=uniquePaths(i+1,j,m,n,dp);
        int right=uniquePaths(i,j+1,m,n,dp);
        return dp[i][j]=down+right;
    }
}
