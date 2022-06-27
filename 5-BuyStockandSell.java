class Solution {
    public int maxProfit(int[] prices)
    {
        
      /* int diff=0;
       int max=0; 
        for(int i=prices.length-1;i>=0;i--)
        {
            for(int j=i-1;j>=0;j--)
            {
                diff=prices[i]-prices[j];
                max=Math.max(max,diff);
            }
        }
        return max;*/
        
        int min=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<min)
            {
                min=prices[i];
            }
            else if(prices[i]-min>max)
            {
                max=prices[i]-min;
            }
        }
        
        return max;
        
    }
}
