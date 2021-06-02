package problems;

/**
 * @author cz
 * @create 2021/6/2 19:47
 */

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class _左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder(s);
        resvere(stringBuilder,0,n-1);
        resvere(stringBuilder,n,length-1);
        resvere(stringBuilder,0,length-1);
        return stringBuilder.toString();
    }
    private void resvere(StringBuilder s , int start, int end){
        while(start < end){
            char c = s.charAt(start);
            s.setCharAt(start,s.charAt(end));
            s.setCharAt(end,c);
            start++;
            end--;
        }
    }
}
