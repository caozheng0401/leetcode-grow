//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 606 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        Arrays.sort(candidates);
        back(candidates,target,0,0,used);
        return res;
    }
    private void back(int[] candidates, int target,int sum, int next,boolean[] used){
        if (sum > target){
            return;
        }
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = next; i < candidates.length && sum + candidates[i] <=target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            sum += candidates[i];
            path.addLast(candidates[i]);
            used[i] = true;
            back(candidates,target,sum,i+1,used);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
