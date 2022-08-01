class Solution {
    
    
    public int Recursion(int ind1,int ind2,String word1,String word2)
    {
        //base case
        if(ind1<0)
        {
            return ind2+1;
        }
        if(ind2<0)
        {
            return ind1+1;
        }
        if(word1.charAt(ind1)==word2.charAt(ind2))
        {
            
            return 0+Recursion(ind1-1,ind2-1,word1,word2);
        }
        return 1+Math.min(Recursion(ind1,ind2-1,word1,word2),Math.min(Recursion(ind1-1,ind2,word1,word2),Recursion(ind1-1,ind2-1,word1,word2)));
    }
    
    public int Memorization(int ind1,int ind2,String word1,String word2,int [][]dp)
    {
       
         //base case
        if(ind1==0)
        {
            return ind2;
        }
        if(ind2==0)
        {
            return ind1;
        }
        if(dp[ind1][ind2]!=0)
        {
            return dp[ind1][ind2];
        }
        if(word1.charAt(ind1-1)==word2.charAt(ind2-1))
        {
            
            return dp[ind1][ind2]=0+Memorization(ind1-1,ind2-1,word1,word2,dp);
        }
        return dp[ind1][ind2]=1+Math.min(Memorization(ind1,ind2-1,word1,word2,dp),Math.min(Memorization(ind1-1,ind2,word1,word2,dp),Memorization(ind1-1,ind2-1,word1,word2,dp)));
    }
    
    public int Tabulation(int ind1,int ind2,String word1,String word2,int [][]dp)
    {
        for(int i=0;i<=ind1;i++)
        {
            dp[i][0]=i;
        }
        for(int i=0;i<=ind2;i++)
        {
            dp[0][i]=i;
        }
        for(int i=1;i<=ind1;i++)
        {
            for(int j=1;j<=ind2;j++)
            {
             if(word1.charAt(i-1)==word2.charAt(j-1))
             {
            
              dp[i][j]=0+dp[i-1][j-1];
             }
            else
            {
             dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));   
            }
          }
        }
        return dp[ind1][ind2];
    }
    public int minDistance(String word1, String word2) {
        
        int ind1=word1.length();
        int ind2=word2.length();
        int dp[][]=new int[ind1+1][ind2+1];
        //return Recursion(ind1-1,ind2-1,word1,word2);
        
        //return Memorization(ind1,ind2,word1,word2,dp);
        return Tabulation(ind1,ind2,word1,word2,dp);
        
    }
}
