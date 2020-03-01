package zhf.src.basic_class_08;

/**
 * Created by ZHF on 2018/8/25.
 */
public class Cow {
    public static int cow(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        return cow(n - 1) + cow(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(cow(8));

    }
}
