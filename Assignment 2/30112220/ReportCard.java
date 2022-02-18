package edu.ucalgary.ensf409;

public class ReportCard {
    private final Booking REPORT;

    public ReportCard(Booking reportInfo){
        this.REPORT = reportInfo;
    }

    public String printReport(){
        String returnString = REPORT.getCaregiver().getName()
                + " enjoyed taking care of "
                + REPORT.getBookedPet().getName()
                + ". See you next time!";
        return returnString;
    }
}
