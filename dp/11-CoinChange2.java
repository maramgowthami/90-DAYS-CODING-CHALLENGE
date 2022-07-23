class Solution {
    
    public int RecursionWays(int ind,int amount,int [] coins)
    {
        
       if(ind==0)
       {
         if(amount%coins[0]==0)
         {
             return 1;
         }
           return 0;
       }
      int Nottake=RecursionWays(ind-1,amount,coins);
        int Take=0;
      if(coins[ind]<=amount)
      {
          Take= RecursionWays(ind,amount-coins[ind],coins); 
      }
        
       return Nottake+Take;     
    }
    public int Memorization(int ind,int amount,int [] coins,int [][]dp)
    {
       if(ind==0)
       {
         if(amount%coins[0]==0)
         {
             return 1;
         }
           return 0;
       }
       if(dp[ind][amount]!=0)
       {
            return dp[ind][amount];
       }
      int Nottake=RecursionWays(ind-1,amount,coins);
      int Take=0;
      if(coins[ind]<=amount)
      {
          Take= RecursionWays(ind,amount-coins[ind],coins); 
      }
        
       return dp[ind][amount]=Nottake+Take;      
    }
    public  int  Tabulation(int amount,int []coins,int [][]dp)
    {
        int n=coins.length;
       for(int T=0;T<=amount;T++)
       {
           if(T%coins[0]==0)
           {
               dp[0][T]=1;
           }
       }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
             int Nottake=dp[i-1][j];
             int Take=0;
             if(coins[i]<=j)
             {
              Take=dp[i][j-coins[i]]; 
             }
             dp[i][j]=Take+Nottake;
            }
        }
        return dp[n-1][amount];
    }
    
    public int SpaceOptimization(int amount, int[] coins)
    {
        int n=coins.length;
        int prev[]=new int[amount+1];
       
       for(int T=0;T<=amount;T++)
       {
           if(T%coins[0]==0)
           {
              prev[T]=1;
           }
       }
        for(int i=1;i<n;i++)
        { 
            int curr[]=new int[amount+1];
            for(int j=0;j<=amount;j++)
            {
             int Nottake=prev[j];
             int Take=0;
             if(coins[i]<=j)
             {
              Take=prev[j-coins[i]]; 
             }
             curr[j]=Take+Nottake;
            }
            prev=curr;
        }
        return prev[amount]; 
    }
    
 
    
    public int change(int amount, int[] coins) 
    {
        int n=coins.length;
       // return  RecursionWays(n-1,amount,coins);  
        int dp[][]=new int[n][amount+1];
        //return Memorization(n-1,amount,coins,dp);
        return Tabulation(amount,coins,dp);
        //return SpaceOptimization(amount,coins);
    }
    
}
