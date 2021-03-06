package problems;

/**
 * @author cz
 * @create 2021/5/16 1:02
 */

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _35搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int middle = left + ((right - left) >> 1);
//            if (nums[middle] == target) {
//                return middle;
//            } else if (nums[middle] > target) {
//                right = middle - 1;
//            } else if (nums[middle] < target) {
//                left = middle + 1;
//            }
//        }
//        return right + 1;
        //暴力：只要求到比这个值大或者相等的值就是我们想要的结果
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
