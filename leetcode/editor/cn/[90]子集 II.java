//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 592 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private void back(int[] nums, int start, int[] used){

        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]&& used[i-1]==0){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = 1;
            back(nums,i+1,used);
            path.removeLast();
            used[i] = 0;
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = 0;
        }
        back(nums,0,used);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
