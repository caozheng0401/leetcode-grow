//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 313 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        back(n,k,0,1);
        return res;
    }
    private void back(int targetNum, int k, int sum, int start){
        if (targetNum < sum){
            return;
        }
        if (path.size() == k) {
            if (targetNum == sum){
                res.add(new ArrayList<>(path));
            }
            return;

        }
        for (int i = start; i <= 9 ; i++) {
            sum += i;
            path.addLast(i);
            back(targetNum,k,sum,i+1);
            sum -= i;
            path.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
