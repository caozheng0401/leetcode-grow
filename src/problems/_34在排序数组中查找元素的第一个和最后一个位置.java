package problems;

/**
 * @author cz
 * @create 2021/5/16 1:29
 */

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 我们先来查找左边界，左边界很容易查找，也就是从左往右找到的第一个不小于x的数
 * ①首先确定分界点mid，mid为区间的中点mid = l + r >> 1;
 * ②然后再判断nums[mid]是否小于target，小于则代表答案在右边且不包含mid这个点，否则就代表答案在左边且包含mid这个点
 * ③接下来继续下一次查找，直到l >= r，跳出循环
 * 查找右边界和左边界差不多，也就是从左往右找到的第一个不大于x的数
 * ①首先确定分界点mid，mid为区间的中点mid = l + r + 1 >> 1;（加1为了防止死循环）
 * ②然后判断nums[mid]是否小于等于target，小于等于则代表答案在右边且包含mid这个点，否则就代表答案在左边且不包含mid这个点
 * ③最后继续下一次查找，直到l >= r，跳出循环
 */
public class _34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] a = new int[]{-1, -1};

        if (nums.length == 0)
            return a;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = r + l >> 1;
            if (nums[mid] >= target)
                r = mid;        //代表答案在左边且包含mid这个点
            else
                l = mid + 1;    //代表答案在右边且不包含mid这个点
        }
        int left = l;
        if (nums[left] != target)    //如果target在数组不存在
            return a;
        else {
            l = 0;
            r = nums.length - 1;
            while (l < r) {
                int mid = r + l + 1 >> 1;   //加1为了防止死循环
                if (nums[mid] <= target)
                    l = mid;        //代表答案在右边且包含mid这个点
                else
                    r = mid - 1;    //代表答案在左边且不包含mid这个点
            }
            return new int[]{left, r};

        }
    }


}

class A {
    public void main(String[] args) {

    }

    public int[] test(int[] nums, int target) {
        int[] a = new int[]{-1, -1};
        if (nums.length == 0) {
            return a;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] >= target) {
                right = middle -1;
            } else {
                left = middle + 1;
            }
        }
        int l = left;
        if (left >= nums.length){
            return a;
        }
        if (nums[left] != target){
            return a;
        }
        else {
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int middle = left + ((right - left) >> 1);
                if (nums[middle] <= target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }}
        return new int[]{l,right};
    }
}