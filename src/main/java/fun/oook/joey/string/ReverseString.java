package fun.oook.joey.string;

import cn.hutool.http.HttpUtil;

/**
 * @author Joey
 * @version 1.0
 * @since 2019/2/19 17:40
 */
public class ReverseString {

    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0; i < s.length / 2; i++) {
            tmp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = tmp;
        }
    }


    public static void main(String[] args) {
        char[] hello = {'h', 'e', 'l', 'l', 'o'};

        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(hello);

        System.out.println(hello);
    }
}
