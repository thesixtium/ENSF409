/**
 @author	Philippa Madil <author
 href="mailto:philippa.madill@ucalgary.ca">philippa.madill@ucalgary</a>
 @version 1.4
 @since 1.0
 */
import java.util.*;


public class simpleArraysPhilippa {
    String[] stringArray = new String[4];

    public simpleArraysPhilippa(String fillElement) {
        Arrays.fill(stringArray, fillElement);
    }

    public simpleArraysPhilippa() {
        Arrays.fill(stringArray, "Hello World");

    }

    public String arrayConcat(int index) {
        String rangedArrayValues = "";
        if (index >= stringArray.length) {
            throw new IndexOutOfBoundsException();
        } else {
            for (String tmpValue : stringArray) {
                System.out.println(tmpValue);
            }
        }
        for (int i = index; i < stringArray.length; i++) {
            rangedArrayValues += stringArray[i];
            if (i != (stringArray.length - 1)) {
                rangedArrayValues = rangedArrayValues + "#";
            }
        }
        return rangedArrayValues;
    }

    public String arrayConcat() {
        return arrayConcat(0);
    }

    public String arrayCrop(int start, int end) {
        String rangedArrayValues = "";
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (start < 0 || end >= stringArray.length) {
            return "Fail";
        }
        if (start == end) {
            return "Match";
        }
        for (int i = start; i <= end; i++) {
            rangedArrayValues = rangedArrayValues + stringArray[i];
            if (i != end) {
                rangedArrayValues = rangedArrayValues + "#";
            }
        }
        return rangedArrayValues;
    }

    public static void main(String[] args) {
        SimpleArrays stringArray1 = new SimpleArrays();
        String foundResult1 = stringArray1.arrayConcat();
        System.out.println(foundResult1);
        SimpleArrays stringArray2 = new SimpleArrays();
        String foundResult2 = stringArray2.arrayConcat(2);
        System.out.println(foundResult2);
        SimpleArrays stringArray3 = new SimpleArrays("Hi you");
        String foundResult3 = stringArray3.arrayConcat();
        System.out.println(foundResult3);
        SimpleArrays stringArray4 = new SimpleArrays("Hi you");
        String foundResult4 = stringArray4.arrayConcat(2);
        System.out.println(foundResult4);
        SimpleArrays stringArray5 = new SimpleArrays("Hi you");
        String foundResult5 = stringArray5.arrayCrop(0, 2);
        System.out.println(foundResult5);
        SimpleArrays stringArray6 = new SimpleArrays("Hi you");
        String foundResult6 = stringArray6.arrayCrop(3, 2);
        System.out.println(foundResult6);
        SimpleArrays stringArray7 = new SimpleArrays("Hi you");
        String foundResult7 = stringArray7.arrayCrop(0, 6);
        System.out.println(foundResult7);
        SimpleArrays stringArray8 = new SimpleArrays("Hi you");
        String foundResult8 = stringArray8.arrayCrop(3, 3);
        System.out.println(foundResult8);
    }
}