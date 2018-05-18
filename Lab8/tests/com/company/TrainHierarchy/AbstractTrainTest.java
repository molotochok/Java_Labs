package com.company.TrainHierarchy;

import com.company.Exceptions.Exception;
import com.company.Exceptions.NullPointerException;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractTrainTest {

    @Test
    public void addCarriage() throws Exception {
        AbstractTrain train = new CouchetteTrain();
        AbstractCarriage carriage = new PassengerCarriage(1,22,8,4);
        train.addCarriage(carriage);

        assertEquals(1,  train.getCarriages()[0].getIndex());
        assertEquals(22, train.getCarriages()[0].getPassengerCount());
        assertEquals(8,  train.getCarriages()[0].getBaggageCount());
        assertEquals(4,  train.getCarriages()[0].getLevelOfComfort());
    }

    @Test
    public void sort() throws Exception {
        AbstractTrain train = new CouchetteTrain();
        for(int i = 2;i>=0;i--){
            AbstractCarriage carriage = new PassengerCarriage(i,i,i,i);
            train.addCarriage(carriage);
        }

        assertEquals(2, train.getCarriages()[0].getIndex());
        assertEquals(1, train.getCarriages()[1].getIndex());
        assertEquals(0, train.getCarriages()[2].getIndex());

        train.sort();

        assertEquals(0, train.getCarriages()[0].getIndex());
        assertEquals(1, train.getCarriages()[1].getIndex());
        assertEquals(2, train.getCarriages()[2].getIndex());
    }

    @Test
    public void findCarPassengerRange() throws NullPointerException{
        AbstractTrain train = new CouchetteTrain();
        for(int i = 0;i<5;i++){
            AbstractCarriage carriage = new PassengerCarriage(i,i,i,i);
            train.addCarriage(carriage);
        }
        Carriage foundCarriage = train.findCarPassengerRange(3,4);
        if(foundCarriage == null)
            throw new NullPointerException();

        assertEquals(3, foundCarriage.getPassengerCount());
    }

    @Test
    public void calcPassengerSum() throws Exception {
        AbstractTrain train = new CouchetteTrain();
        for(int i = 0;i<5;i++){
            AbstractCarriage carriage = new PassengerCarriage(i,i,i,i);
            train.addCarriage(carriage);
        }
        int passengerSum = train.calcPassengerSum();

        assertEquals(10, passengerSum);
    }

    @Test
    public void calcBaggageSum() throws Exception {
        AbstractTrain train = new CouchetteTrain();
        for(int i = 0;i<6;i++){
            AbstractCarriage carriage = new PassengerCarriage(i,i,i,i);
            train.addCarriage(carriage);
        }
        int baggageSum = train.calcBaggageSum();

        assertEquals(15, baggageSum);
    }
}