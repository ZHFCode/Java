/**
 * Created by ZHF on 2018/9/10.
 */
public class LongestPalindromicSubString {
    /**
     * 005-Longest Palindromic Substring（最长回文子串）
     *
     * @param s 输入的字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLength = 0;
        String longest = null;

        int length = s.length();
        boolean[][] table = new boolean[length][length];

        // 单个字符都是回文
        for (int i = 0; i < length; i++) {
            table[i][i] = true;
            longest = s.substring(i, i + 1);
            maxLength = 1;
        }

        // 判断两个字符是否是回文
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                longest = s.substring(i, i + 2);
                maxLength = 2;
            }
        }
        // 求长度大于2的子串是否是回文串
        for (int len = 3; len <= length; len++) {
            for (int i = 0, j; (j = i + len - 1) <= length - 1; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] && maxLength < len) {
                        longest = s.substring(i, j + 1);
                        maxLength = len;
                    }
                } else {
                    table[i][j] = false;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "sasaabbbbaass";
        System.out.println(longestPalindrome(s));

    }
}

