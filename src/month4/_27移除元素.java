/**
 * @author cz
 * @create 2021/4/20 8:07
 */

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *解题思路：设两个指针，i1指向下一个赋值的位置，也就是不等于val的值，i2指向要处理的元素。
 *         如果他俩不相等，i1不动，i2指向下一个位置，如果相等，i2继续向前，等到碰见下一个不相等的值，i1会覆盖掉相等的值。
 */
public class _27移除元素 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
