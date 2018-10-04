/**
 * Created by ZHF on 2018/9/9.
 */
public class BigNumMultiply {
    public static char[] reverse(char[] chars) {
        char[] temp = new char[chars.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = chars[temp.length - 1 - i];
        }
        return temp;
    }
    public static String multiply(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[] n1 = new int[c1.length];
        int[] n2 = new int[c2.length];

        for (int i = 0; i < n1.length; i++) {
            n1[i] = c1[i] - '0';
        }
        for (int i = 0; i < n2.length; i++) {
            n2[i] = c2[i] - '0';
        }

        int[] result = new int[n1.length + n2.length];

        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                result[i + j] += n1[i] * n2[j];
            }
        }

        for (int i = result.length-1; i >0 ; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        String s = "";
        for (int i = 0; i < result.length-1; i++) {
            s += ""+result[i];
        }
        return s;
    }
    public static void main(String[] args) {
        String s1 = "2233";
        String s2 = "12334";
        System.out.println(multiply(s1,s2));
        System.out.println(bigNumAdd(s1, s2));
    }

    public static String bigNumAdd(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] n1 = new int[c1.length];
        int[] n2 = new int[c2.length];

        for (int i = 0; i < n1.length; i++) {
            n1[i] = c1[i] - '0';
        }
        for (int i = 0; i < n2.length; i++) {
            n2[i] = c2[i] - '0';
        }
        int l1 = n1.length-1, l2 = n2.length-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while ((l1 < n1.length && l1 >= 0) || (l2 < n2.length && l2 >= 0) || carry > 0) {
            int tmp = 0;
            if (l1 < n1.length && l1 >= 0) {
                tmp += n1[l1];
                l1--;
            }
            if (l2 < n2.length && l2 >= 0) {
                tmp += n2[l2];
                l2--;
            }
            tmp += carry;
            carry = tmp / 10;
            sb.insert(0, tmp % 10 + "");
        }
        return sb.toString();
    }
}
