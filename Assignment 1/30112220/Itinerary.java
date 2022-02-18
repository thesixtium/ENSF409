package edu.ucalgary.ensf409;
import edu.ucalgary.ensf409.*;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2022
All rights reserved.
*/

/**
 * @author: Aleksander Berezowski
 * @UCID: 30112220
 * @version: 1.9
 * @since: 1.0
 */

public class Itinerary {
    private Trip[] trips = new Trip[20];

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        return value + " (" + key + ")";
    }

    // Constructor
    public Itinerary(String[][] myTrips) {
        for ( int i = 0; i < myTrips.length; i++){
            this.trips[i] = new Trip(myTrips[i]);
        }
    }

    // Getter
    public Trip[] getTrips() {
        return this.trips;
    }

    public String formatByArrival() {
        StringBuilder returnString = new StringBuilder(3000);
        String prevYear = String.valueOf(Trip.getYear(trips[0].getArrival()));
        String prevMonth = String.valueOf(Trip.getMonth(trips[0].getArrival()));
        String nowYear = "";
        String nowMonth = "";

        String appendString = fmtString("Year", prevYear)
                + "\n--"
                + fmtString("Month", prevMonth)
                + "\n";
        returnString.append(appendString);

        for (int i = 0; i < trips.length; i++){
            if(trips[i] != null){
                nowYear = String.valueOf(Trip.getYear(trips[i].getArrival()));
                nowMonth = String.valueOf(Trip.getMonth(trips[i].getArrival()));
                if(!prevYear.equals(nowYear)){
                    appendString = fmtString("Year", nowYear) + "\n";
                    returnString.append(appendString);
                    prevYear = nowYear;
                }
                if(!prevMonth.equals(nowMonth)){
                    appendString = "--"
                            + fmtString("Month", nowMonth)
                            + "\n";
                    returnString.append(appendString);
                    prevMonth = nowMonth;
                }
                appendString = "----"
                        + fmtString("City", trips[i].getCity())
                        + ", "
                        + fmtString("Country", trips[i].getCountry())
                        + " (Place)\n";
                returnString.append(appendString);
            }
        }
        returnString.setLength(returnString.length() - 1);
        return returnString.toString();
    }

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {
        String[][][] returnArray = new String[3][12][1];
        for (int x = 0; x < returnArray.length; x++){
            for (int y = 0; y < returnArray[0].length; y++){
                for (int z = 0; z < returnArray[0][0].length; z++){
                    returnArray[x][y][z] = "null";
                }
            }
        }
        for (Trip trip : trips){
            if (trip != null){
                int year = Trip.getYear(trip.getArrival());
                int month = Trip.getMonth(trip.getArrival());
                if(returnArray[year - 2021][month-1][0] == "null"){
                    returnArray[year - 2021][month-1][0] = trip.formatByArrival();
                }
            }
        }

        return returnArray;
    }

}
