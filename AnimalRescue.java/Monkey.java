import java.util.Arrays;
import java.util.List;

public class Monkey extends RescueAnimal {

    // Accepted MonkeysCapuchin 
    private static final List<String> acceptedMonkeys = Arrays.asList("Guenon", "Macaque", "Marmoset", "Squirrel", "Tamarin");

    private String tailLength;
    private String height; 
    private String bodyLength;
    private String species;
    
    public Monkey(String name,String gender, String age, String weight, String acquisitionDate, 
    String acquisitionCountry,String trainingStatus, boolean reserved, String inServiceCountry, 
    String tailLength, String hieght, String bodyLength, String specie)
    {
        setTailLength(tailLength);
        setHeight(hieght);
        setBodyLength(bodyLength);
        setSpecies(specie);
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    public void setTailLength(String monkyTailLength){
        tailLength = monkyTailLength;
    }

    public String getTailLength(){
        return tailLength;
    }

    public  void setHeight(String monkyHeight){
        height = monkyHeight; 
    }

    public String getHeight(){
        return height;
    }

    public void setBodyLength(String monkyBodyLength){
        bodyLength = monkyBodyLength;
    }

    public String getBodyLength(){
        return bodyLength;
    }

    public void setSpecies(String monkeySpecies){
            if (acceptedMonkeys.contains(monkeySpecies)) {
                species = monkeySpecies;
            } else {
                System.out.println("Species is not accepted. Species must be one of the following: " + acceptedMonkeys);
            }
        
    
    }

    public String getSpecies(){
        return species;
    }

}
