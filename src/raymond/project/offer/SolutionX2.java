package raymond.project.offer;

import java.util.*;

public class SolutionX2 {

    /**
     * 给定一个正整数，给出消除重复数字以后最大的整数，注意需要考虑长整数。
     *
     * 输入示例：423234
     * 输出示例：432
     * @param args
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        Integer[] arr = new Integer[10];

        for(int i = 0;i < s.length();++i) {
            arr[s.charAt(i) - '0'] = 1;
        }

        StringBuffer buffer = new StringBuffer();
        for(int i = 9;i >= 0;i--) {
            if(arr[i] != null) {
                buffer.append(i);
            }
        }

        System.out.println(buffer.toString());
    }
}