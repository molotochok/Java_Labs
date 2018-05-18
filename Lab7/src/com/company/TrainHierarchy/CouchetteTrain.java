package com.company.TrainHierarchy;

public class CouchetteTrain extends AbstractTrain {

    public CouchetteTrain(){
        super();
    }

    public CouchetteTrain(Locomotive locomotives, PassengerCarriage[] passengerCarriages){
        super(locomotives, passengerCarriages);
    }
}
