/**
 * @author: Aleksander Berezowski
 * @version: 1.4
 * @since: 1.0
 */

import java.util.Arrays;

public class SimpleArrays {

    // The class has an instance variable (a 4-element array of Strings)
    String[] myStringArray = new String[4];

    // Has a constructor which can be called with one argument: a String
    public SimpleArrays(String fillElement){
        Arrays.fill(myStringArray, fillElement);
    }

    // Overloads the constructor with a zero argument version
    public SimpleArrays(){
        Arrays.fill(myStringArray, "Hello, world");
    }

    // Provides a method arrayConcat
    public String arrayConcat(int arrayIndex){
        var returnString = "";

        // This method should have default behavior if the index supplied exceeds the bounds of the
        //array (IndexOutofBoundsException error)
        if(arrayIndex >= myStringArray.length){
            throw new IndexOutOfBoundsException();
        } else if (arrayIndex == 0){
            arrayIndex = myStringArray.length;
        }

        for (int counter = 0; counter < arrayIndex; counter++){
            returnString += myStringArray[counter];
            if (counter != arrayIndex-1){
                returnString += "#";
            }
        }

        //Returns a String consisting of all the elements of the array, from the provided index to the
        //end, concatenated, separated by the # character (no whitespace should be introduced)
        return returnString;
    }

    // If no array index is supplied, 0 is used by default
    public String arrayConcat(){
        return arrayConcat(0);
    }

    // Provides a method arrayCrop
    //Accepts two integers as arguments, corresponding to starting and ending array indices. The
    //starting and ending indices are inclusive.
    public String arrayCrop(int startingIndex, int endIndex){
        if (startingIndex == endIndex){
            // If the two integers are the same, return "Match"
            return "Match";
        } else if (startingIndex > endIndex){
            //If the ending integer is smaller than the starting integer, switch the two (use the start as the
            //end, and the end as the start)
            var temp = startingIndex;
            startingIndex = endIndex;
            endIndex = temp;
        } else if (startingIndex < 0 || endIndex > myStringArray.length){
            // If either integer is not a valid index, return "Fail"
            return "Fail";
        }

        myStringArray = Arrays.copyOfRange(myStringArray,startingIndex, endIndex + 1);

        //Returns a String consisting of all the elements between the two indices specified, concate-
        //nated, separated by the # character (no whitespace should be introduced)
        return arrayConcat();
    }

    public static void main(String[] args){
        SimpleArrays myArray1 = new SimpleArrays();
        String foundResult1 = myArray1.arrayConcat();
        System.out.println(foundResult1);
        SimpleArrays myArray2 = new SimpleArrays();
        String foundResult2 = myArray2.arrayConcat(2);
        System.out.println(foundResult2);
        SimpleArrays myArray3 = new SimpleArrays("Hi you");
        String foundResult3 = myArray3.arrayConcat();
        System.out.println(foundResult3);
        SimpleArrays myArray4 = new SimpleArrays("Hi you");
        String foundResult4 = myArray4.arrayConcat(2);
        System.out.println(foundResult4);
        SimpleArrays myArray5 = new SimpleArrays("Hi you");
        String foundResult5 = myArray5.arrayCrop(0, 2);
        System.out.println(foundResult5);
        SimpleArrays myArray6 = new SimpleArrays("Hi you");
        String foundResult6 = myArray6.arrayCrop(3, 2);
        System.out.println(foundResult6);
        SimpleArrays myArray7 = new SimpleArrays("Hi you");
        String foundResult7 = myArray7.arrayCrop(0, 6);
        System.out.println(foundResult7);
        SimpleArrays myArray8 = new SimpleArrays("Hi you");
        String foundResult8 = myArray8.arrayCrop(3, 3);
        System.out.println(foundResult8);
    }

}
