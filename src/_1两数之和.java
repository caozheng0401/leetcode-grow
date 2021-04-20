/**
 * @author cz
 * @create 2021/4/20 9:36
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路：使用两个数，挨个循环，最后两个数相加得到和target相同的数，记录位置，添加到数组里面。
 */
public class _1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+ nums[j] == target){
                    a.add(i);
                    a.add(j);
                }
            }
        }
        int[] b = {a.get(0),a.get(1)};
        return b;
    }
}
