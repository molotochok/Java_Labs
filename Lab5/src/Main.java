import java.util.Scanner;

public class Main {

    //region helpful Methods
    private static int getValue(final String message){
        int result = 0;
        boolean exit = false;
        while(!exit){
            Scanner in = new Scanner(System.in);
            result = 0;
            System.out.print(message + " = ");
            if(in.hasNextInt()){
                result = in.nextInt();
                exit = true;
            }
        }

        return result;
    }

    private static Carriage createCarriage(int index){
        boolean exit = false;
        Scanner in = new Scanner(System.in);
        int passengerCount   = getValue("Passenger Count");
        int baggageCount     = getValue("Baggage Count");
        int levelOfComfort   = getValue("Level Of Comfort");

        return new PassengerCarriage(index, passengerCount, baggageCount, levelOfComfort);
    }
    private static Locomotive createLocomotive(){
        Locomotive newLocomotive = null;

        int locomotiveDecision;
        boolean exit = false;

        while(!exit){
            System.out.print("Choose locomotive (Diesel - 1, Electric - 2): ");
            Scanner in = new Scanner(System.in);
            if(in.hasNextInt()){
                locomotiveDecision = in.nextInt();
                switch (locomotiveDecision){
                    case 1:
                        newLocomotive = new DieselLocomotive();
                        exit = true;
                        break;
                    case 2:
                        newLocomotive = new ElectricLocomotive();
                        exit = true;
                        break;
                    default:
                        System.out.println("You should write only 1 or 2!!!");
                        break;
                }
            }else{
                System.out.println("You should write only 1 or 2!!!");
            }
        }
        return newLocomotive;
    }
    //endregion

    public static void main(String[] args) {
        // Initializing locomotive
        Locomotive locomotive = createLocomotive();
        locomotive.setMaxSpeed(getValue("Locomotive max speed"));
        locomotive.setPower(getValue("Locomotive power"));

        int numberOfCarriages = getValue("\nNumber of Carriages");
        if(numberOfCarriages < 0){
            System.out.println("Amount of Carriages can't be less than 0!!!");
            return;
        }
        System.out.println("\nInput Carriage info:");

        // Setup train
        Train train = new CouchetteTrain();
        train.setLocomotive(locomotive);

        for(int i = 0; i < numberOfCarriages; i++){
            System.out.println("Carriage " + (i + 1)+ ":");
            Carriage carriage = createCarriage(i + 1);
            train.addCarriage(carriage);
        }


        // Output train
        System.out.println("Your train:\n" + train);

        // Find amount of all passengers and baggage in train
        System.out.println("Amount of passengers in train: " + train.calcPassengerSum());
        System.out.println("Amount of baggage in train: "    + train.calcBaggageSum());

        // Sort and output train
        train.sort();
        System.out.println("\nSorted train by level of comfort:" + train);

        // Find first carriage where amount of passengers are in range(min,max)
        int min = 0;
        int max = 0;
        System.out.println("Input range of passenger count: ");
        min = getValue("min");
        max = getValue("max");
        Carriage foundCarriage = train.findCarPassengerRange(min, max);
        if(foundCarriage == null){
            System.out.println("There is no such carriage");
        }else{
            System.out.println(train.findCarPassengerRange(min, max));

        }
    }
}