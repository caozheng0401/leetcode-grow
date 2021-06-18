//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 757 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<String>> res = new ArrayList<>();
    private LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        back(s,0);
        return res;
    }

    private void back(String s, int start) {
        if (start >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (is(s,start,i)){
                String substring = s.substring(start, i+1);
                path.add(substring);
            }else {
                continue;
            }
            back(s,i+1);
            path.removeLast();
        }
    }

    private boolean is(String a, int sart, int end) {
        int j = end;
        for (int i1 = sart; i1 < j; i1++) {
            if (a.charAt(i1) != a.charAt(j)){
                return false;
            }
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
