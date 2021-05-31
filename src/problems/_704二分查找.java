package problems;

/**
 * @author cz
 * @create 2021/5/16 0:26
 */

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;      //左区间
        int right = nums.length - 1;    //右区间
        while (left <= right) {       //区间是左闭右闭，所以相等也有效
            int mid = left + ((right - left) >> 1);    //求中间值,除以2  == (left + right) /2
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;             //因为当前mid值制定不等于target
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

//    int search(vector<int>& nums, int target) {
//        int left = 0;
//        int right = nums.size(); // 定义target在左闭右开的区间里，即：[left, right)
//        while (left < right) { // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
//            int middle = left + ((right - left) >> 1);
//            if (nums[middle] > target) {
//                right = middle; // target 在左区间，在[left, middle)中
//            } else if (nums[middle] < target) {
//                left = middle + 1; // target 在右区间，在[middle + 1, right)中
//            } else { // nums[middle] == target
//                return middle; // 数组中找到目标值，直接返回下标
//            }
//        }
//        // 未找到目标值
//        return -1;
    }
}
