package month4;

/**
 * @author cz
 * @create 2021/4/28 9:21
 */

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * link:https://leetcode-cn.com/problems/sum-of-square-numbers/
 * a^2+b^2 == c   返回true
 * a^2+b^2 < c    a++
 * a^2+b^2 > c    b--
 */
public class _633平方数之和 {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while(a <= b){
            int cur = a*a+b*b;
            if (cur == c){
                return true;
            }else if (cur > c){
                b--;
            }else {
                a++;
            }
        }
        return false;

    }
}
