package com.company;

import com.company.TrainHierarchy.*;

import java.util.Scanner;

public class Main{

    //region CreateTrain
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

    private static Train createTrain(){
        Locomotive locomotive = createLocomotive();
        locomotive.setMaxSpeed(getValue("Locomotive max speed"));
        locomotive.setPower(getValue("Locomotive power"));

        int numberOfCarriages = getValue("\nNumber of Carriages");
        if(numberOfCarriages < 0){
            System.out.println("Amount of Carriages can't be less than 0!!!");
            return null;
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
        return train;
    }
    //endregion

    public static void main(String[] args) {
        // Use first(empty constructor
        List<Train> arrayList1 = new ArrayList();
        arrayList1.setDescription("ArrayList1");
        for(int i = 0;i < 3;i++){
            Train newTrain = createTrain();
            arrayList1.add(newTrain);
        }
        arrayList1.output();

        // use constructor which takes an element as a parameter
        Train newTrain = createTrain();
        List<Train> arrayList2 = new ArrayList(newTrain);
        arrayList2.setDescription("ArrayList2");

        arrayList2.output();

        // use constructor which takes an ArrayList object as a parameter
        List<Train> arrayList3 = new ArrayList(arrayList1);
        arrayList3.setDescription("ArrayList3");

        arrayList3.output();

    }
}
