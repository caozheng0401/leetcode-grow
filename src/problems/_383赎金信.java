package problems;

/**
 * @author cz
 * @create 2021/6/1 19:41
 */

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 */
public class _383赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ints = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            ints[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {

            if (ints[ransomNote.charAt(i) - 'a'] >0){
                ints[ransomNote.charAt(i) - 'a']--;
            }else {
                return false;
            }
        }
        return true;
    }
}
