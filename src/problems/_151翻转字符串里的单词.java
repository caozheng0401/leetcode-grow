package problems;

/**
 * @author cz
 * @create 2021/6/2 19:03
 */

/**
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 * <p>
 * 说明：
 * <p>
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }
//    public String reverseWords(String s) {
//        StringBuilder remove = remove(s);
//        reserve(remove,0,s.length()-1);
//        return reserveWord(remove);
//    }
//
//    private StringBuilder remove(String s) {
//        int start = 0;
//        int end = s.length() - 1;
//        while(start <= end &&s.charAt(start) == ' ') start++;
//        while(start <= end &&s.charAt(end) == ' ') end--;
//        StringBuilder res = new StringBuilder();
//        while (start <= end) {
//            char c = s.charAt(start);
//            if (c != ' ' || res.charAt(res.length() - 1) != ' ') {
//                res.append(c);
//            }
//            start++;
//        }
//        return res;
//    }
//    private void reserve(StringBuilder s, int start, int end ){
//        while(start < end){
//            char c = s.charAt(start);
//            s.setCharAt(start,s.charAt(end));
//            s.setCharAt(end,c);
//            start++;
//            end--;
//        }
//    }
//    private String reserveWord(StringBuilder s){
//        int start = 0;
//        int end = 0;
//        int length = s.length();
//        while(start < length){
//            while(  end < length && s.charAt(end)!=' '){
//                end++;
//            }
//            reserve(s,start,end -1);
//            start = end+1;
//            end = start+1;
//        }
//        return s.toString();
//    }
}