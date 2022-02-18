/**
 * @author Aleksander Berezowski <author
 * href="mailto:aleksander.berezowsk@ucalgary.ca">aleksander.berezowsk@ucalgary.ca</author>
 * @version 1.0
 * @since 1.0
 */

import java.util.*;
import java.lang.*;
import java.util.regex.*;

public class JavaStrings {

    public int addTogether(String stringOne, String stringTwo){
        // Accept two Strings as arguments

        //Trim leading and trailing whitespaces from each String
        String trimedStringOne = stringOne.trim();
        String trimedStringTwo = stringTwo.trim();

        //Add strings together
        String concatenatedString = trimedStringOne.concat(trimedStringTwo);

        //Return the length of the trimmed, concatenated String
        return concatenatedString.length();
    }

    public String idProcessing(String firstName, String lastName, String petName, int year){
        //Accept three Strings and an integer as arguments

        //make desiredIndentifier as First Initial, Last Initial, Pet Name Initial, Year
        String desiredIdentifier = String.valueOf(firstName.charAt(0)) +
                String.valueOf(lastName.charAt(0)) +
                String.valueOf(petName.charAt(0)) +
                String.valueOf(year);

        // Return the identifier
        return desiredIdentifier;
    }

    public String secretCode(String decodedString){
        //Accept a string as an argument
        /* Old stuff
        String encodedString = decodedString.substring(0,3);

        char[] vowelArray = {'a', 'e', 'i', 'o', 'u'};

        for (char j : vowelArray) {
            encodedString = encodedString.replace(j, 'z');
            encodedString = encodedString.replace(Character.toUpperCase(j), 'z');
        }
         */

        String encodedString = decodedString.replaceAll("([a,e,i,o,u,A,E,I,O,U]+)", "z");
        encodedString = getSecretCodeRegex(encodedString);

        return encodedString;
    }
    private static Pattern SECRET_CODE_REGEX = Pattern.compile("^.{3}");
    public static String getSecretCodeRegex(String content){
         Matcher matcher = SECRET_CODE_REGEX.matcher(content);
         matcher.find();
         return String.valueOf(matcher.group());
    }

    public static void main(String[] args) {
        JavaStrings myObject = new JavaStrings();

        // Print out examples from addTogether.
        String oneExample = "12 4 6789";
        String twoExample = "abcdef gh";
        int theLength = myObject.addTogether(oneExample,twoExample);
        System.out.println(theLength);

        // Length is unchanged by adding whitespace to front and back
        oneExample = "   " + oneExample + "\n";
        twoExample = "\t" + twoExample;
        theLength = myObject.addTogether(oneExample,twoExample);
        System.out.println(theLength);

        // Print out example of idProcessing
        String personFirst = "Dorothy";
        String personLast = "Gale";
        String petName = "Toto";
        int petBirth = 1899;
        String theID = myObject.idProcessing(personFirst,personLast,
                petName,petBirth);
        System.out.println(theID);

        // Print out examples from secretCode
        String ingredientOne = "tomato";
        String ingredientTwo = "WATER";
        String theCode = myObject.secretCode(ingredientOne);
        System.out.println(theCode);
        theCode = myObject.secretCode(ingredientTwo);
        System.out.println(theCode);
    }
}
