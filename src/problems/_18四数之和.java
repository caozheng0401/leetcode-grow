package problems;

/**
 * @author cz
 * @create 2021/6/1 23:08
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class _18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0 || nums == null) {
            return list;
        }
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (i1 > i+1 && nums[i1] == nums[i1 - 1]) {
                    continue;
                }
                int left = i1+1;
                int right = nums.length-1;
                while(right > left){
                    int tem = nums[i] +nums[i1]+nums[left]+nums[right];
                    if (tem > target){
                        right--;
                    }else if (tem < target){
                        left++;
                    }else {
                        list.add(Arrays.asList(nums[i] ,nums[i1],nums[left],nums[right]));
                        while (right > left && nums[left] == nums[left +1 ])  left++;
                        while (right > left && nums[right] == nums[right -1 ])  right--;
                        left++;
                        right--;

                    }
                }
            }
        }
        return list;
    }
}
