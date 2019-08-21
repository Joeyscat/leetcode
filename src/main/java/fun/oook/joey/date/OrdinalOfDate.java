package fun.oook.joey.date;

/**
 * 一年中的第几天
 * https://leetcode-cn.com/contest/weekly-contest-149/problems/ordinal-number-of-date/
 * <p>
 * https://zh.wikipedia.org/wiki/%E6%A0%BC%E9%87%8C%E6%9B%86
 */
public class OrdinalOfDate {
    public int ordinalOfDate(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        int[] arr;
        boolean leap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        if (leap) {
            // 闰年
            arr = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        } else {
            // 平年
            arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }
        int ordinal = 0;
        for (int i = 0; i < month - 1; i++) {
            ordinal += arr[i];
        }
        ordinal += day;
        return ordinal;
    }

    public static void main(String[] args) {

        String date = "2003-03-01";
        int ordinal = new OrdinalOfDate().ordinalOfDate(date);

        System.out.printf("%s 该年的第 %d 天%n",date, ordinal);
    }

}
