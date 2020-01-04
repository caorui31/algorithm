package raymond.project.wechat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionThree {

    public int Max(List<List<Integer>> list) {

        // up用来记录飞机起飞时间，down用来记录飞机降落时间
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        for(List<Integer> current : list) {
            up.add(current.get(0));
            down.add(current.get(1));
        }
        // 排序
        Collections.sort(up);
        Collections.sort(down);


        int max = 0;
        int current = 0;
        while(up.size() > 0 && down.size() > 0) {
            if(up.get(0) < down.get(0)) {
                // 此时有一台飞机起飞
                ++current;
                up.remove(0);
                if(current > max) {
                    max = current;
                }
            }  else {
                --current;
                down.remove(0);
            }
        }

        return max;
    }

    public static void main(String[] args) throws Exception{
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(10, 15));
        lists.add(Arrays.asList(8, 15));
        lists.add(Arrays.asList(7, 11));
        lists.add(Arrays.asList(11, 13));
        lists.add(Arrays.asList(7, 16));
        lists.add(Arrays.asList(8, 10));
        lists.add(Arrays.asList(9, 13));


        SolutionThree solutionThree = new SolutionThree();
        System.out.println(solutionThree.Max(lists));
    }
}
