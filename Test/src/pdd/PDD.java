package pdd;

/**
 * Created by ZHF on 2018/8/5.
 */
public class PDD {
    //被血虐
    public static void main(String[] args) {
        String s = "abcdefghijklmnop";
        String res=answer(s);
        System.out.println(res);
    }

    public static String answer(String str) {
        int k = str.length() / 4;
        String res = "";
        for(int i = 0; i < k + 1; i++) {
            res += str.charAt(i);
        }
        res += "\r\n";
        for(int i = 0; i < k - 1; i++) {
            res += str.charAt(str.length() - 1 - i);
            for(int j = 0; j < k - 1; j++) {
                res += " ";
            }
            res += str.charAt(k + i + 1);
            res += "\r\n";
        }
        for(int i = 3 * k; i >= 2 * k; i--) {
            res += str.charAt(i);
        }
        return res;
    }

    public static int answer2(String str) {
        int res = 0;
        for(int i = 1; i < str.length(); i++) {
            int a = helper(str.substring(0, i));
            int b = helper(str.substring(i));
            res += a * b;
        }
        return res;
    }

    private static int helper(String s) {
        if(s.length() == 1) {
            return 1;
        }
        if(s.charAt(0) == '0' && s.charAt(s.length() - 1) == '0') {
            return 0;
        }
        if(s.charAt(0) == '0' || s.charAt(s.length() - 1) == '0') {
            return 1;
        }
        return s.length();
    }


}
