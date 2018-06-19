package task04;

import java.util.Arrays;

public class Task04Test {
    public static void main(String[] args) {
        String str = "12 33 25 17 29 64 -11 77 82 35";
        System.out.println(str);
        System.out.println(sorts(str));

    }

    private static String sorts(String str) {
        String[] sepStr_arr = separates(str);
        int[] int_arr = stringsToInt(sepStr_arr);
        int[] sortInt_arr = sorting(int_arr);

        return intsToString(sortInt_arr);

//        return intsToString(sorting(stringsToInt(separates(str))));
    }

    private static String[] separates(String str) {
        return str.split(" ");
    }

    private static int[] stringsToInt(String[] str) {
        int[] ints = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            ints[i] = Integer.parseInt(str[i]);
        }
        return ints;
    }

    private static int[] sorting(int[] ints) {
        Arrays.sort(ints);
        return ints;
    }

    private static String intsToString(int[] ints) {
        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            if (i != ints.length - 1) {
                sbl.append(ints[i]).append(" ");
            } else {
                sbl.append(ints[i]);
            }
        }
        return sbl.toString();
    }
}
