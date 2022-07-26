package DPOnStrings;
import java.util.*;
public class LongestCommonSubsequences
{
    public static int Recursion(int ind1,int ind2,String a,String b)
    {
       if(ind1<0 || ind2 <0)
       {
           return 0;
       }
       if(a.charAt(ind1)==b.charAt(ind2))
       {
            return 1+ Recursion(ind1-1,ind2-1,a, b);
       }
       return Math.max( Recursion(ind1-1,ind2,a, b),Recursion(ind1,ind2-1,a, b));
    }
    public static int Memorization(int ind1,int ind2,String a,String b,int [][] dp)
    {
        if(ind1<0 || ind2 <0)
        {
            return 0;
        }
        if(dp[ind1][ind2]!=0)
        {
            return dp[ind1][ind2];
        }
        if(a.charAt(ind1)==b.charAt(ind2))
        {
            return 1+  Memorization(ind1-1,ind2-1,a, b,dp);
        }
        return dp[ind1][ind2]=Math.max(Memorization(ind1-1,ind2,a, b,dp), Memorization(ind1,ind2-1,a, b,dp));
    }
    public static int Tabulation(int ind1,int ind2,String a,String b,int [][] dp)
    {

        for(int j=0;j<=ind2;j++)
        {
            dp[0][j]=0;
        }
        for(int i=0;i<=ind1;i++)
        {
            dp[i][0]=0;
        }
        for(int i=1;i<=ind1;i++)
        {
            for(int j=1;j<=ind2;j++)
            {
                if(a.charAt(i-1)==b.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        }
        return dp[ind1][ind2];
    }
     public static int SpaceOptimization(int ind1,int ind2,String a,String b)
    {
      int prev[]=new int[ind2+1];
      int curr[]=new int[ind2+1];
        for(int j=0;j<=ind2;j++)
        {
            prev[j]=0;
        }

        for(int i=1;i<=ind1;i++)
        {
            for(int j=1;j<=ind2;j++)
            {
                if(a.charAt(i-1)==b.charAt(j-1))
                {
                    curr[j]=1+prev[j-1];
                }
                else {
                   curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
          prev=(int[])(curr.clone());

        }
        return prev[ind2];
    }
    

    public static void main(String[] args) {
        String str1="acd";
        String str2="ced";
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        System.out.println("Recursion->"+Recursion(2,2,str1,str2));
        System.out.println("Memorization->"+ Memorization(2,2,str1, str2,dp));
        System.out.println("Tabulation->"+Tabulation(str1.length(),str2.length(),str1, str2,dp));
        System.out.println("SpaceOptimization->"+SpaceOptimization(str1.length(),str2.length(),str1, str2));



    }
}
