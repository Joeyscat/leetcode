package fun.oook.joey.string;

/**
 * @author Joey
 * @version 1.0
 * @since 2019/3/4 11:04
 */
public class ReverseInteger {

    public int reverse(int x) {
        if (x > (Integer.MAX_VALUE) || x < Integer.MIN_VALUE) {
            return 0;
        }
        String str;
        if (x < 0)
            str = Integer.toString(x).substring(1);
        else
            str = Integer.toString(x);
        char[] chars = str.toCharArray();
        reverseString(chars);

        str = String.copyValueOf(chars);
        long y = Long.parseLong(str);
        if (y > (Integer.MAX_VALUE) || -y < Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0)
            return -Integer.valueOf(str);
        return Integer.valueOf(str);
    }

    public static void main(String[] args) {

        ReverseInteger reverseInteger = new ReverseInteger();
        int num = -2147483648;
        num = reverseInteger.reverse(num);

        System.out.println(num);
    }

    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0; i < s.length / 2; i++) {
            tmp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = tmp;
        }
    }
}
