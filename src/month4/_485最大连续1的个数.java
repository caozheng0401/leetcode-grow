public class _485最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0,count=0;
        int i;
        for (int i1 = 1; i1 < nums.length; i1++) {
            if (nums[i1] == 1){
                count++;
            }else {
                maxCount = Math.max(count,maxCount);
                count = 0;
            }
        }
        maxCount = Math.max(count,maxCount);
        return maxCount;
    }
}
