package raymond.project.leetcode;


public class S41 {

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int ans[] = new int[length];

        for(int i = 0;i < length;++i) {
            if(nums[i] > 0 && nums[i] < length) {
                ans[nums[i]-1] = nums[i];
            }
        }

        for(int i = 0;i < length; ++i) {
            if(i+1 != ans[i]) {
                return i+1;
            }
        }
        return length+1;
    }

    public static void main(String[] args) throws Exception{
        S41 s = new S41();
        int[] arr = new int[]{1};
        s.firstMissingPositive(arr);
    }
}
