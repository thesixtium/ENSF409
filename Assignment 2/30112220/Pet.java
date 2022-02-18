package edu.ucalgary.ensf409;

public class Pet {
    private final String NAME;
    private final String SPECIES;
    private final String BREED;
    private final String COLOUR;
    private boolean vaccineStatus;
    private Client owner;
    private EmergVet vet;
    private CareProfile care;

    public Pet(String name, String species, String breed, String colour, Client owner){
        this.NAME = name;
        this.SPECIES = species;
        this.BREED = breed;
        this.COLOUR = colour;
        this.owner = owner;
        this.vaccineStatus = false;
    }

    public void setVet(EmergVet vet){
        this.vet = vet;
    }

    public EmergVet getVet(){
        return this.vet;
    }

    public void updateVaccineStatus(boolean change){
        this.vaccineStatus = change;
    }

    public boolean getVaccineStatus(){
        return this.vaccineStatus;
    }

    public void setCare(String[] meds, String medInstr, String feedingInstr){
        this.care = new CareProfile(meds, medInstr, feedingInstr);
    }

    public String getCareSummary(){
        StringBuilder returnString = new StringBuilder(3000);

        returnString.append("Care for ")
                .append(this.NAME)
                .append(":\n")
                .append(this.care.summarizeCareInstructions());

        return returnString.toString();
    }

    public Client getOwner(){
        return this.owner;
    }

    public void setOwner(Client updateOwner) {
        this.owner = updateOwner;
    }

    public String getName(){
        return this.NAME;
    }

    public String getSpecies(){
        return this.SPECIES;
    }

    public String getBreed(){
        return this.BREED;
    }

    public String getColour(){
        return this.COLOUR;
    }
}