import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.Arrays;

public class ClimbStairs {

    public static void main(String[] args) {
        int n =45;

        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n+1];
        return dp(n,memo);
    }

    public static int dp(int n,int[] memo){
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(memo[n]!=0)
            return memo[n];
        return dp(n-1,memo)+dp(n-2,memo);
    }

}
