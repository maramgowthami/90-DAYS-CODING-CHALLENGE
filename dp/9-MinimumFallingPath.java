/** Method1(RECURSION)**/
// Time Complexity:-O(3^m*n)
//Space Complexity:-O(m-1+n-1)

/** Method2(Memorization)**/
//Time Complexity:-O(n*m)
//Space Complexity:-O(m-1+n-1)+O(m*n)
/** Method3(Tabulation)**/
//Time Complexity:-O(n*m)+O(n)
//Space Complexity:-O(m*n)
/** Method4(Optimal)**/
//Time Complexity:O(n*m)
//Space Complexity:-O(n)
class Solution {
    
    public int minFallingpathSumRec(int i,int j,int[][] matrix)
    {
        int m=matrix.length;
      
        if(j<0  || j>=m)
        {
            return (int)Math.pow(10,9);
        }
        if(i==0)
        {
            return matrix[0][j];
        }
        //straight path
        int s=matrix[i][j]+ minFallingpathSumRec(i-1,j,matrix);
        //left diagonal
        int ld=matrix[i][j]+ minFallingpathSumRec(i-1,j-1,matrix);
        //right diagonal
        int rd=matrix[i][j]+ minFallingpathSumRec(i-1,j+1,matrix);
        
        return Math.min(s,Math.min(ld,rd));
    }
    public int minFallingpathSumMemorization(int i,int j,int[][] matrix,int [][]dp)
    {
        int m=matrix.length;
      
        if(j<0  || j>=m)
        {
            return (int)Math.pow(10,9);
        }
        if(i==0)
        {
            return matrix[0][j];
        }
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        //straight path
        int s=matrix[i][j]+ minFallingpathSumRec(i-1,j,matrix);
        //left diagonal
        int ld=matrix[i][j]+ minFallingpathSumRec(i-1,j-1,matrix);
        //right diagonal
        int rd=matrix[i][j]+ minFallingpathSumRec(i-1,j+1,matrix);
        
        return dp[i][j]= Math.min(s,Math.min(ld,rd));
    }
    public int minFallingPathSumTabulation(int [][]matrix,int [][]dp)
    {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int j=0;j<n;j++)
        {
            dp[0][j]=matrix[0][j];
        }
        
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
              
              
                int s=matrix[i][j]+dp[i-1][j];
                int ld=matrix[i][j];
                if(j-1>=0)
                {
                ld+=dp[i-1][j-1];
                }
                else
                {
                    ld+=Math.pow(10,9);
                }
                
                int rd=matrix[i][j];
                if(j+1<m)
                {
                rd+=dp[i-1][j+1];
                }
                else
                {
                    rd+=Math.pow(10,9);
                }
                
                dp[i][j]= Math.min(s,Math.min(ld,rd));
            }
            
        }
        int mini=dp[m-1][0];
        for(int j=1;j<n;j++)
        {
            mini=Math.min(mini,dp[m-1][j]);
        }
        return mini;
    }
    
    public int minFallingPathSumSpaceOptmization(int [][]matrix)
    {
        int m=matrix.length;
        int n=matrix[0].length;
        int prev[]=new int[n];
       
        for(int j=0;j<n;j++)
        {
           prev[j]=matrix[0][j];
        }
        
        for(int i=1;i<m;i++)
        {
             int cur[]=new int [n];
            for(int j=0;j<n;j++)
            {
              
              
                int s=matrix[i][j]+prev[j];
                int ld=matrix[i][j];
                if(j-1>=0)
                {
                ld+=prev[j-1];
                }
                else
                {
                    ld+=Math.pow(10,9);
                }
                
                int rd=matrix[i][j];
                if(j+1<m)
                {
                rd+=prev[j+1];
                }
                else
                {
                    rd+=Math.pow(10,9);
                }
                
              cur[j]= Math.min(s,Math.min(ld,rd));
            }
            prev=cur;
            
        }
        int mini=prev[0];
        for(int j=1;j<n;j++)
        {
            mini=Math.min(mini,prev[j]);
        }
        return mini;
    }
    public int minFallingPathSum(int[][] matrix) 
    {
        
        int m=matrix.length;
        int n=matrix[0].length;
        int mini=(int)Math.pow(10,9);
        int dp[][]=new int[m][n];
        //Recursion
        /*for(int j=0;j<n;j++)
        {
            mini=Math.min(mini,minFallingpathSumRec(m-1,j,matrix));
        }
        return mini;*/
        
        //Memorization
        /*for(int j=0;j<n;j++)
        {
            mini=Math.min(mini,minFallingpathSumMemorization(m-1,j,matrix,dp));
        }
        return mini;*/
        //Tabulation
        //return minFallingPathSumTabulation(matrix,dp);
        //Space Optimization
        return minFallingPathSumSpaceOptmization(matrix);
    }
}
