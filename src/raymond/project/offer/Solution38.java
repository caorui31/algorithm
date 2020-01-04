package raymond.project.offer;

import raymond.project.ListNode;

public class Solution38 {

    /**
     * 字符串的全排列
     */
    public void permutation(String str) {
        if(str == null) {
            return ;
        }

        permutation(str.toCharArray(), 0, str.length() - 1);
    }

    public void permutation(char[] str, int from, int to) {
        if(from == to) {
            System.out.println(str);
        } else {
            for(int i = from;i <= to; ++i) {
                swap(str, i, from);
                permutation(str, from + 1, to);
                swap(str, i, from);
            }
        }
    }

    public static void swap(char[] s,int i,int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) throws Exception{
        String str = "abc";
        Solution38 s = new Solution38();
        s.permutation(str);
    }
}
