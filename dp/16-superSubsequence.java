package DPOnStrings;

public class SuperSubsequence
{

    public static String Tabulation(int ind1,int ind2,String a,String b,int [][] dp)
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
        int len=dp[ind1][ind2];
        String ans="";
        int i=ind1;
        int j=ind2;
        StringBuilder result=new StringBuilder(ans);
        while(i>0 && j>0)
        {
            if(a.charAt(i-1)==b.charAt(j-1))
            {

                ans+=a.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1])
            {
                ans+=a.charAt(i-1);
                i--;
            }
            else {
                ans+=b.charAt(j-1);
                j--;
            }
        }
        while(i>0)
        {
            ans+=a.charAt(i-1);
            i--;
        }
        while(j>0)
        {
            ans+=b.charAt(j-1);
            j--;
        }
        StringBuilder temp=new StringBuilder();
        temp.append(ans);
        temp.reverse();
        return temp.toString();
    }
    public static void main(String[] args)
    {
        String a="brute";
        String b="groot";
        int a_len=a.length();
        int b_len=b.length();
        int [][]dp=new int[a_len+1][b_len+1];
        System.out.println(Tabulation(a_len,b_len,a,b,dp));


    }
}
