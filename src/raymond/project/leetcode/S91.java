package raymond.project.leetcode;


public class S91 {

    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }
        Integer dp[] = new Integer[s.length()+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1;i < s.length();++i ) {
            if(s.charAt(i) == '0') {
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    dp[i+1] = dp[i-1];
                } else {
                    return 0;
                }
            } else {
                if(s.charAt(i - 1) == '1') {
                    dp[i+1] = dp[i] + dp[i-1];
                } else if(s.charAt(i - 1) == '2'
                        && s.charAt(i) >= '1' && s.charAt(i) <= '6' ) {
                    dp[i+1] = dp[i] + dp[i-1];
                } else {
                    dp[i+1] = dp[i];
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) throws Exception{
        S91 s = new S91();
        s.numDecodings("226");
    }
}
