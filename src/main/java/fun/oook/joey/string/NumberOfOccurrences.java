package fun.oook.joey.string;

public class NumberOfOccurrences {

    private int numberOfOccurrences(String str, String target) {
        String strWithoutTarget = str.replaceAll(target, "");
        return (str.length() - strWithoutTarget.length()) / target.length();
    }

    private int numberOfOccurrences2(String str, String target) {
        String[] strings = str.split(target);
        String strWithoutTarget = String.join("", strings);
        return (str.length() - strWithoutTarget.length()) / target.length();
    }


    public static void main(String[] args) {
        String str = "this is simple file";
        String target = " i";

        int times = new NumberOfOccurrences().numberOfOccurrences2(str, target);
        System.out.println(times);
    }
}
