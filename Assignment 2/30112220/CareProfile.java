package edu.ucalgary.ensf409;

public class CareProfile {
    private String[] medList;
    private String medInstructions;
    private String feedingInstructions;

    public CareProfile(String[] medList, String meds, String feeding){
        this.medList = medList;
        this.medInstructions = meds;
        this.feedingInstructions = feeding;
    }

    public String summarizeCareInstructions(){
        StringBuilder returnString = new StringBuilder(3000);

        for(String j: medList){
            returnString.append(j + ", ");
        }
        returnString.setLength(returnString.length() - 2);
        returnString.append("\n"
                + this.medInstructions
                + "\n"
                + this.feedingInstructions);

        return returnString.toString();
    }
}
