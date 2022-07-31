class Solution {
    
    /*public int Recursion(int ind1,int ind2,String s,String t,int [][]dp)
    {
      
       if(ind2<0)
       {
         return 1;
       }
       if(ind1<0)
       {
          return 0;
       }
       if(dp[ind1][ind2]!=0)
       {
           return dp[ind1][ind2];
       }
       if(s.charAt(ind1)==t.charAt(ind2))
       {
          return dp[ind1][ind2]=Recursion(ind1-1,ind2-1,s,t,dp)+Recursion(ind1-1,ind2,s,t,dp);
       }
       else
       {
          return dp[ind1][ind2]=Recursion(ind1-1,ind2,s,t,dp);
       }

        
    }
    */
    public int Tabulation(int ind1,int ind2,String s,String t,int [][]dp)
    {
        for(int i=0;i<=ind1;i++)
        {
            dp[i][0]=1;
        }
        for(int j=1;j<=ind2;j++)
        {
            dp[0][j]=0;
        }
        
        for(int i=1;i<=ind1;i++)
        {
            for(int j=1;j<=ind2;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[ind1][ind2];
    }
    
    public int numDistinct(String s, String t) 
    {
        
        int ind1=s.length();
        int ind2=t.length();
        int dp[][]=new int[ind1+1][ind2+1];
        //return Recursion(ind1-1,ind2-1,s,t,dp);
        return Tabulation(ind1,ind2,s,t,dp);
    }
}
