import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(sumStrings("993933249328", "98273497392"));
    }
    public static String sumStrings(String a, String b) {
        if (a.equals("") & b.equals("")) {
            return "0";
        }
        if (a.equals("")) {
            return b;
        }
        if (b.equals("")) {
            return a;
        }
        String[] array1 = a.split("");
        String[] array2 = b.split("");

        String[] resArray1 = testZeros(array1);
        String[] resArray2 = testZeros(array2);

        String[] newArray1 = reverseArray(resArray1);
        String[] newArray2 = reverseArray(resArray2);

        if (newArray1.length > newArray2.length) {

            List<Integer> list = newList(newArray2, newArray1);
            StringBuilder str = new StringBuilder();
            list.forEach(str::append);
            return getStringRemainder(newArray2, newArray1) + str;

        } else if (newArray2.length > newArray1.length) {

            List<Integer> list = newList(newArray1, newArray2);
            StringBuilder str = new StringBuilder();
            list.forEach(str::append);
            return getStringRemainder(newArray1, newArray2) + str;

        } else {
            List<Integer> list = newList(newArray1, newArray2);
            StringBuilder str = new StringBuilder();
            list.forEach(str::append);
            return str.toString();
        }
    }

    public static String getStringRemainder(String[] minArray, String[] maxArray) {
        String[] array = Arrays.copyOfRange(reverseArray(maxArray), 0, maxArray.length - minArray.length);
        StringBuilder str = new StringBuilder();
        for (String s : array) str.append(s);
        return String.valueOf(str);
    }

    public static String[] reverseArray(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    public static List<Integer> newList(String[] minArray, String[] maxArray) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < minArray.length; i++) {
            int res = Integer.parseInt(maxArray[i]) + Integer.parseInt(minArray[i]);
            if (res > 9) {
                String str = String.valueOf(res);
                String[] strings = str.split("");
                if (i == maxArray.length - (maxArray.length - minArray.length)) {
                    break;
                }
                if (maxArray.length != minArray.length) {
                    maxArray[i + 1] = String.valueOf(Integer.parseInt(maxArray[i + 1]) + Integer.parseInt(strings[0]));
                    list.add(Integer.parseInt(strings[1]));
                } else {
                    if (i == maxArray.length - 1) {
                        list.add(res);
                    } else {
                        maxArray[i + 1] = String.valueOf(Integer.parseInt(maxArray[i + 1]) + Integer.parseInt(strings[0]));
                        list.add(Integer.parseInt(strings[1]));
                    }
                }
            } else {
                list.add(res);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static String[] testZeros(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String s : array) {
            list.add(Integer.parseInt(s));
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                list.remove(i);
                i--;
            } else {
                break;
            }
        }
        String[] resultArray = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultArray[i] = String.valueOf(list.get(i));
        }
        return resultArray;
    }
}
