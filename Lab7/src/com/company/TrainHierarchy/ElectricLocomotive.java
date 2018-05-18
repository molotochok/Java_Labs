package com.company.TrainHierarchy;

public class ElectricLocomotive extends AbstractLocomotive{

    public ElectricLocomotive(){
        super();
        DieselLocomotive.type = "Electric";
    }

    public ElectricLocomotive(int power, int maxSpeed){
        super(power, maxSpeed);
        DieselLocomotive.type = "Electric";
    }
}
