package com.company.TrainHierarchy;

public class FreightCarriage extends AbstractCarriage{

    public FreightCarriage(){
        super();
    }
    public FreightCarriage(int index, int baggageCount){
        super(index,  0, baggageCount, 0);
    }
}
