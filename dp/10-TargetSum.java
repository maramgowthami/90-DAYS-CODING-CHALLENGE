class Solution 
{
    
    public static int  SubsetSequenceTabulation(int []arr,int target)
    {
     int n=arr.length;
      int [][] dp=new int[n][target+1];
    
      if(arr[0]==0)
      {
          dp[0][0]=2;
      }
      else 
      {
          dp[0][0]=1;
      }
      if( arr[0]!=0 && arr[0]<=target)
      {
          dp[0][arr[0]]=1;
      }
       for(int i=1;i<n;i++)
       {
           for(int j=0;j<=target;j++) {

               int NotPick=dp[i-1][j];
               int Pick=0;
               if (arr[i]<=j)
               {
                   Pick= dp[i-1][j-arr[i]];
               }
              dp[i][j]=Pick+NotPick;
           }
       }
       return dp[n-1][target];
    }
    public static int countPartitions(int n, int d,int[] arr){
    int totSum = 0;
    for(int i=0; i<n;i++){
        totSum += arr[i];
    }
    
    //Checking for edge cases
    if(totSum-d <0 || (totSum-d)%2==1 ) return 0;
    
    return SubsetSequenceTabulation(arr,(totSum-d)/2);
   }
    
    public int findTargetSumWays(int[] nums, int target) 
    {
        int n=nums.length;
         
        return countPartitions(n,target,nums);
    }
}
