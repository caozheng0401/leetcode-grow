package problems;

/**
 * @author cz
 * @create 2021/5/16 2:49
 */
public class _69x的平方根 {
    private int mySqrt(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        long left = 2;
        long right = x ;
        // 在区间 [left..right] 查找目标元素
        while (left <= right) {
            long mid = left + ((right - left) >> 2);
            long temp = mid * mid;
            // 注意：这里为了避免乘法溢出，改用除法
            if (temp > x ) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else if (temp < x){
                // 下一轮搜索区间是 [mid..right]
                left = mid + 1;
            }else if (temp == x){
                return (int)mid;
            }
        }
        return (int)right;
    }

}
