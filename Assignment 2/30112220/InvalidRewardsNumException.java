package edu.ucalgary.ensf409;

public class InvalidRewardsNumException extends Exception {
    public InvalidRewardsNumException(){
        super("Input does not only contain numbers");
    }
}
