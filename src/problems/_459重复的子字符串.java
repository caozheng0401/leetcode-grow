package problems;

/**
 * @author cz
 * @create 2021/6/5 23:05
 */
public class _459重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0){
            return false;
        }
        int[] next = new int[s.length()];
        getNext(next,s);
        if (next[s.length()-1] != -1 && next.length % (next.length - (next[s.length()-1] +1))==0){
            return true;
        }
        return false;
    }
    private void getNext(int[] next, String moodle){
        int j = -1;
        char[] chars = moodle.toCharArray();
        next[0] = -1;
        for (int i = 1; i < moodle.length(); i++) {
            while(j >= 0 && chars[i] != chars[j+1]){
                j = next[j];
            }
            if (chars[i] == chars[j+1]){
                j++;
            }
            next[i] = j;
        }
    }
}
