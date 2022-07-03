class Solution {
    public int minimumTotal(List<List<Integer>> triangle) 
    { 
        //return  minimumTotal(0,0,triangle);
          int m=triangle.size();
          int dp[][]=new int[m][m];
        //return Memorization(0,0,triangle,dp);
         //return Tabulation(triangle,dp);
        return SpaceOptimization(triangle);
    }
    public int SpaceOptimization(List<List<Integer>> triangle)
    {
        int n=triangle.size();
        int front[]=new int [n];
        for(int j=0;j<n;j++)
        {
            front[j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--)
        {
            int cur[]=new int[n];
            for(int j=i;j>=0;j--)
            {
                int down=triangle.get(i).get(j)+front[j];
                int dia=triangle.get(i).get(j)+front[j+1];
                cur[j]=Math.min(down,dia);
                
            }
            front=cur;
        }
        return front[0];
    }

    public int Tabulation(List<List<Integer>> triangle,int dp[][])
    {
        int n=triangle.size();
        for(int j=0;j<n;j++)
        {
            dp[n-1][j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
                int down=triangle.get(i).get(j)+dp[i+1][j];
                int dia=triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(down,dia);
                
            }
        }
        return dp[0][0];
    }
    public int Memorization(int i,int j,List<List<Integer>> triangle,int dp[][])
    {
        int n=triangle.size();
        if(i==n-1)
        {
            return triangle.get(n-1).get(j);
        }
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        int down=triangle.get(i).get(j)+minimumTotal(i+1,j,triangle);
        int dia=triangle.get(i).get(j)+minimumTotal(i+1,j+1,triangle);
        return dp[i][j]=Math.min(down,dia); 
    }
    public int minimumTotal(int i,int j,List<List<Integer>> triangle)
    {
        int n=triangle.size();
        if(i==n-1)
        {
            return triangle.get(n-1).get(j);
        }
        int down=triangle.get(i).get(j)+minimumTotal(i+1,j,triangle);
        int dia=triangle.get(i).get(j)+minimumTotal(i+1,j+1,triangle);
        return Math.min(down,dia);
    }
    
    
    
}
