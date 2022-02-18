package edu.ucalgary.ensf409;

public class RewardsProfile {
    private String rewardsNum;
    private int pointsTotal;

    public RewardsProfile(){
        this.rewardsNum = "Not enrolled";
        this.pointsTotal = 10;
    }

    public RewardsProfile(String newNumber) throws InvalidRewardsNumException {
        if(!newNumber.matches("[0-9]+")){
            throw new InvalidRewardsNumException();
        }
        this.rewardsNum = newNumber;
        this.pointsTotal = 10;
    }

    public void setPoints(int addPoints){
        this.pointsTotal += addPoints;
    }

    public int getPoints() {
        return this.pointsTotal;
    }

    public String getNumber(){
        return this.rewardsNum;
    }
}
