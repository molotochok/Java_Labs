package com.company;

import com.company.List.ArrayList;
import com.company.List.Iterator;
import com.company.List.List;
import com.company.TrainHierarchy.*;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String FILE_PATH = "C:\\Users\\Markiian\\Desktop\\Learning\\Second course\\Second\\Java\\Labs\\Lab8\\train.txt";

    //region Methods that create trains
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

    private static List initializeList(){
        // Creating ArrayList
        List<Train> list = new ArrayList();

        int amountOfTrains = getValue("Input amount of trains");

        for(int i = 0;i < amountOfTrains;i++){
            Train train = createTrain();
            list.add(train);
        }
        return list;
    }

    public static void main(String[] args) throws IOException{
        // Create ArrayList which contains trains
        List list = initializeList();

        // Create object which saves and loads objects in different ways
        FileManager fileManager = new FileManager(FILE_PATH);

        // --1-- Save and Load List as one object
        // Save
        fileManager.saveObject(list);
        // Load
        System.out.print(fileManager.loadObject());

        // --2-- Save and Load Trains as sequence object
        // Save
        fileManager.saveTrains(list);
        // Load
        System.out.print(fileManager.loadTrains());

        // --3-- Save and Load Objects as text
        // Save
        fileManager.saveObjectAsText(list);
        // Load
        System.out.print(fileManager.loadObjectAsText());
    }
}
