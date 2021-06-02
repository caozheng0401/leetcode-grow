package problems;

/**
 * @author cz
 * @create 2021/6/1 19:57
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class _15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return lists;
            }
            if (i >0 && nums[i] == nums[i -1]){
                continue;
            }
            int left = i +1;
            int right = nums.length - 1;
            while(right > left){
                int tem = nums[i] + nums[left] + nums[right];
                if (tem > 0){
                    right--;
                }else if (tem <0){
                    left++;
                }else {
                    lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(right > left && nums[right] == nums[right -1 ]) right--;
                    while (right > left && nums[left] == nums[left + 1 ])left++;
                    left++;
                    right--;
                }
            }
        }
        return lists;
    }
}
