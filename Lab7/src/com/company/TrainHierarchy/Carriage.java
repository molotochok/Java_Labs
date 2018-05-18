package com.company.TrainHierarchy;

public interface Carriage{
    // Setter
    void setIndex(int index);
    void setPassengerCount(int passengerCount);
    void setBaggageCount(int baggageCount);
    void setLevelOfComfort(int levelOfComfort);
    // Getter
    int getIndex();
    int getPassengerCount();
    int getBaggageCount();
    int getLevelOfComfort();

    // Methods
    void initializeValues(int index, int passengerCount, int baggageCount, int levelOfComfort);
}

