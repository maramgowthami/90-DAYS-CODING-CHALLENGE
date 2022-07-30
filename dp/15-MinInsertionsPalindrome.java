class Solution {
    
    public int Tabulation(int ind1,int ind2,String a,String b,int [][]dp)
    {
        
      
       
        for(int i=0;i<=ind1;i++)
        {
            dp[i][0]=0;
            
        }
        for(int j=0;j<=ind2;j++)
        {
            dp[0][j]=0;
        }
        for(int i=1;i<=ind1;i++)
        {
            for(int j=1;j<=ind2;j++)
            {
               
             if(a.charAt(i-1)==b.charAt(j-1))
             {
                 dp[i][j]=1+dp[i-1][j-1];
                
             }
             else
             {
                 dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
             }
                
            }
        }
        return dp[ind1][ind2];
        
        
        
    }
  
    
    public int minInsertions(String s) 
    {
       
        
        StringBuilder rs=new StringBuilder();
        rs.append(s);
        rs.reverse();
        String rev_s=rs.toString();
        int s_len=s.length();
        
        int s_rev_len=rev_s.length();
        int [][]dp=new int[s_len+1][s_rev_len+1];
        int longpalindrome=Tabulation(s_len,s_rev_len,s,rev_s,dp);
        return s_len-longpalindrome;
        
    }
}
