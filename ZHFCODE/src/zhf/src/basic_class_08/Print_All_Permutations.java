package zhf.src.basic_class_08;

/**
 * Created by ZHF on 2018/8/25.
 */
public class Print_All_Permutations {
    public static void permutations(String s) {
        permutation(s.toCharArray(),0);
    }

    public static void permutation(char[] chars, int i) {
        if (i == chars.length) {
            System.out.println(String.valueOf(chars));
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            permutation(chars,i+1);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        permutations("abc");

    }
}
