import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Driver {
    private static final List<String> acceptedMonkeys = Arrays.asList("Guenon", "Macaque", "Marmoset", "Squirrel", "Tamarin");
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {
        initializeDogList();
        initializeMonkeyList();

        Scanner scanner = new Scanner(System.in);
        String option = "";
        while (!option.equals("q")) {
            displayMenu();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
        System.out.println("Exiting application.");
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {

        Monkey monkey1 = new Monkey("MonkeyMan", "male", "4", "20", "1-2-2022", "mexico", "in service", true, "Mexico", "4in","14in", "15in", "Guenon");
        Monkey monkey2 = new Monkey("MonkeyRobot", "female", "5", "16", "12-31-1999", "America", " in service", false, "America","12in", "20in", "2ft", "Macaque");
        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
    }


    // Completed the intakeNewDog method
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();// name
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        System.out.println("What is the dogs gender");// gender
        String gender = scanner.next();

        System.out.println("What is the dogs breed");// breed
        String breed = scanner.next();

        System.out.println("What is the dog's weight?");// weight
        int weight = scanner.nextInt();
        String weightString = Integer.toString(weight);

        System.out.println("What is the dog's age?");// age
        int age = scanner.nextInt();
        String ageString = Integer.toString(age);

        System.out.println("What is the dog's status?");// stats
        String status = scanner.next();

        System.out.println("What is the dogs acquaistion date?");
        String acquaistionDate = scanner.next();

        System.out.println("What is the dog's acquisition country?");// country
        String acquisitionCountry = scanner.next();

        System.out.println("Is the dog reserved? (yes/no)");// reserved
        boolean reserved = false;
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            reserved = true;
        }
        
        Dog newDog = new Dog(name, breed, gender, ageString, weightString, acquaistionDate, acquisitionCountry,status,reserved, acquisitionCountry);
        dogList.add(newDog);
    }

        // Completed intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        public static void intakeNewMonkey(Scanner scanner) {
            
                System.out.println("What is the monkey's name?");
                String name = scanner.nextLine();// name
                for(Monkey monkey: monkeyList) {
                    if(monkey.getName().equalsIgnoreCase(name)) {
                        System.out.println("\n\nThis monkey is already in our system\n\n");
                        return; //returns to menu
                    }
                }
                System.out.println("What is the monkey gender");// gender
                String gender = scanner.next();
        
                System.out.println("What is the monkey spiecies");// species
                String species = scanner.next();
        
                System.out.println("What is the monkey's weight?");// weight
                int weight = scanner.nextInt();
                String weightString = Integer.toString(weight);
        
                System.out.println("What is the monkeys's age?");// age
                int age = scanner.nextInt();
                String ageString = Integer.toString(age);
        
                System.out.println("What is the monkeys's status?");// stats
                String status = scanner.next();
        
                System.out.println("What is the monkye's acquaistion date?");
                String acquaistionDate = scanner.next();
        
                System.out.println("What is the monkeys's acquisition country?");// country
                String acquisitionCountry = scanner.next();
        
                System.out.println("Is the monkey reserved? (yes/no)");// reserved
                boolean reserved = false;
                String yesOrNo = scanner.next();
                if (yesOrNo.equalsIgnoreCase("yes")) {
                    reserved = true;
                }

                Monkey newMonkey = new Monkey(name, gender, ageString, weightString, acquisitionCountry, acquisitionCountry, status, reserved, ageString, status, acquaistionDate, acquisitionCountry, species);
                if (acceptedMonkeys.contains(species)) {
                    monkeyList.add(newMonkey);
                } 
                
            
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("What is the type of animal: ");
            String type  = scanner.next();
            System.out.println("Whats your animals service country");
            String serviceCountry = scanner.next();
            System.out.println("Whats the name of your animal");
            String name = scanner.next();


        
            if(type.equalsIgnoreCase("dog")){
            for (Dog dog : dogList) {
                if (dog.getName().equalsIgnoreCase(name) && dog.getInServiceLocation().equalsIgnoreCase(serviceCountry)) {
                    if (dog.getReserved() == true) {
                        System.out.println("\n\nThis dog is already reserved\n\n");
                        return;
                    }
                    dog.setReserved(true);
                    System.out.println("\n\nThe dog has been reserved\n\n");
                    return;
                }
            }
        
            System.out.println("\n\nThis dog was not found in the system\n\n");
         }
         else if(type.equalsIgnoreCase("monkey")){
            for (Monkey monkey : monkeyList) {
                if (monkey.getName().equalsIgnoreCase(name) && monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry)) {
                    if (monkey.getReserved() == true) {
                        System.out.println("\n\nThis monkey is already reserved\n\n");
                        return;
                    }
                    monkey.setReserved(true);
                    System.out.println("\n\nThe monkey has been reserved\n\n");
                    return;
                }
            }
        
            System.out.println("\n\nThis monkey was not found in the system\n\n");
         }
         else{
            
                System.out.println("This animal type is not supported");

         }
        }
        // Completed printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
        public static void printAnimals(String str) {

            if (str == "dog"){
                for(Dog dog : dogList) {
                    System.out.println("Dog name: " + dog.getName() + ", training states: " + dog.getTrainingStatus() + ", acquisition date: " +  dog.getAcquisitionDate() +", reserve states: "+ dog.getReserved() );
                }
            }

            else if (str == "monkey"){
                for(Monkey monkey : monkeyList) {
                       System.out.println("Monkey Name: " + monkey.getName() + ", Training status: " + monkey.getTrainingStatus() + ", acquisition date: " + monkey.getAcquisitionDate() + ", reserve states: " + monkey.getReserved());
                }
            }
            else if (str == "available"){  
                for(Monkey monkey : monkeyList){  
                    if(monkey.getReserved() == false){
                        System.out.println("Monkey Name: " + monkey.getName() + ", Training status: " + monkey.getTrainingStatus() + ", acquisition date: " + monkey.getAcquisitionDate() + ", reserve states: " + monkey.getReserved());
                    }
                } 

                for(Dog dog : dogList){
                    if(dog.getReserved() == false){
                        System.out.println("Dog name: " + dog.getName() + ", training states: " + dog.getTrainingStatus() + ", acquisition date: " +  dog.getAcquisitionDate() +", reserve states: "+ dog.getReserved() );
                      }
                    }
                }
            }

        
}

