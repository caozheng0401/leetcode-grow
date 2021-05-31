package problems;

/**
 * @author cz
 * @create 2021/5/31 21:15
 */

import java.util.HashSet;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 */
public class _202快乐数 {
    public boolean isHappy(int n) {
//        HashSet<Integer> integers = new HashSet<>();
//        while (!integers.contains(n) && n != 1){
//            integers.add(n);
//            n = getNumber(n);
//        }
//        return n == 1;
    }

    //    private int getNumber(int n) {
//        int res = 0;
//        while (n > 0) {
//            int tem = n % 10;
//            res += tem * tem;
//            n = n / 10;
//        }
//        return res;
//    }
    private int get(int n) {
        int re = 0;
        while (n > 0) {
            int tem = n % 10;
            re += tem * tem;
            n = n / 10;
        }
        return re;
    }
    public boolean a(int n){
        HashSet<Integer> integers = new HashSet<>();
        while (!integers.contains(n) && n != 1){
            integers.add(n);
            n = get(n);
        }
    }
}
