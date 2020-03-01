package zhf.src.basic_class_08;

/**
 * Created by ZHF on 2018/8/25.
 * 打印一个字符串的子序列
 */
public class Print_All_Subsquences {
    public static void printAllSubSequence(String s) {
        printAllSub(s.toCharArray(),0,"");
    }

    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i + 1, res+String.valueOf(str[i]));
        printAllSub(str,i+1,res);

    }

    public static void main(String[] args) {
        printAllSubSequence("abc");
    }
}
