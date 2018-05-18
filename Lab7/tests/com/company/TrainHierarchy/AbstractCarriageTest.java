package com.company.TrainHierarchy;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractCarriageTest {

    @Test
    public void initializeValues() {
        AbstractCarriage carriage = new PassengerCarriage();

        carriage.initializeValues(1,2,3,4);

        assertEquals(1,carriage.getIndex());
        assertEquals(2,carriage.getPassengerCount());
        assertEquals(3,carriage.getBaggageCount());
        assertEquals(4,carriage.getLevelOfComfort());
    }

}