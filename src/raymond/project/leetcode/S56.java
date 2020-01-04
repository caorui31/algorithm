package raymond.project.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S56 {

    public int[][] merge(int[][] intervals) {
        // 对intevals排序
        List<int[]> ans = new ArrayList<>();
        if(intervals == null
                || intervals.length == 0) {
            return ans.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] current = new int[2];
        current[0] = intervals[0][0];
        current[1] = intervals[0][1];
        for(int i = 1;i < intervals.length;) {
            // 判断i和i+1是否能合并
            if(current[1] >= intervals[i][0]) {
                // 可以合并
                current[1] = intervals[i][1];
                i++;
            } else {
                ans.add(current.clone());

                current[0] = intervals[i][0];
                current[1] = intervals[i][1];
                i++;
                if(i == intervals.length) {
                    ans.add(intervals[intervals.length-1]);
                }
            }
        }

        return ans.toArray(new int[0][]);
    }


    public static void main(String[] args) throws Exception{
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        S56 s = new S56();
        s.merge(a);
    }
}
