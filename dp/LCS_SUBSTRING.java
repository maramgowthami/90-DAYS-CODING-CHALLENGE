class Solution {
    
    public int Tabulation(int ind1,int ind2,int [] nums1,int [] nums2,int [][]dp)
    {
        
      
        int ans=0;
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
               
             if(nums1[i-1]==nums2[j-1])
             {
                 dp[i][j]=1+dp[i-1][j-1];
                 ans=Math.max(ans,dp[i][j]);
             }
             else
             {
                 dp[i][j]=0;
             }
                
            }
        }
        return ans;
        
        
        
    }
    public int findLength(int[] nums1, int[] nums2) 
    {
       int dp[][]=new int[nums1.length+1][nums2.length+1];
       return Tabulation(nums1.length,nums2.length,nums1,nums2,dp); 
        
    }
}
