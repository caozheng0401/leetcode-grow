package problems; /**
 * @author cz
 * @create 2021/5/19 0:59
 */

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _209长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;    //滑动窗口的值
        int i = 0;      //滑动窗口的初始位置
        int length = 0;    //滑动窗口长度
        for (int j = 0; j < nums.length; j++) {
            sum +=nums[j];
            while (sum >= target){
                length = j - i + 1;
                result = result < length ? result : length;
                sum -= nums[i++];
            }
        }
        return result == Integer.MAX_VALUE ? 0:result;

    }
}
