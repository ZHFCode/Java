package thoughtwork;

/**
 * Created by ZHF on 2018/9/21.
 */
public class TextProcessor {
    static class Node{
        public String text;
        public int lineNum;

        public Node(String text, int lineNum) {
            this.text = text;
            this.lineNum = lineNum;
        }

        @Override
        public String toString() {
            return this.text + "(" + this.lineNum + ");";
        }
    }

    public String process(String text, int width) {
        int len = text.length();
        int fullLine = len / 10;
        int lsatLine = len % 10;

        int start = 0;
        int end = 0;
        for (int i = 0; i < fullLine; i++) {
            end = start+width;
            String s = text.substring(start, end);
            for (int j = 0; j < s.length(); j++) {
                
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
