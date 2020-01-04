package raymond.project.leetcode;


public class S59 {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int r0 = 0;
        int r1 = n-1;
        int c0 = 0;
        int c1 = n-1;
        int num = 1;
        int max = n * n;
        while(num <= max) {
            for(int i = c0;i <= c1;++i) {
                ans[r0][i] = num++;
            }
            r0++;
            for(int i = r0;i <= r1;i++) {
                ans[i][c1] = num++;
            }
            c1--;
            for(int i = c1;i >= c0;i--) {
                ans[r1][i] = num++;
            }
            r1--;
            for(int i = r1;i >= r0;i--) {
                ans[i][c0] = num++;
            }
            c0++;
        }

        return ans;
    }

    public static void main(String[] args) throws Exception{
        S59 s = new S59();
        s.generateMatrix(3);
    }
}
