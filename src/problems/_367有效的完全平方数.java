package problems;

/**
 * @author cz
 * @create 2021/5/16 13:05
 */
public class _367有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        // 特殊值判断

        if (num == 1) {
            return true;
        }

        long left = 2;
        long right = num ;
        // 在区间 [left..right] 查找目标元素
        while (left <= right) {
            long mid = left + ((right - left ) >> 2);
            long temp = mid * mid;
            // 注意：这里为了避免乘法溢出，改用除法
            if (temp == num ) {
                // 下一轮搜索区间是 [left..mid - 1]
                return true;
            } else if(temp > num  ){
                // 下一轮搜索区间是 [mid..right]
                right = mid - 1;
            }else if(temp < num  ){
                // 下一轮搜索区间是 [mid..right]
                left = mid + 1;
            }
        }
        return false;
    }
}
