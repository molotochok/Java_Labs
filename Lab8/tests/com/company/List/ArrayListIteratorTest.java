package com.company.List;

import com.company.TrainHierarchy.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListIteratorTest {

    @Test
    public void hasNext() {
        List list = new ArrayList();

        Train train = new CouchetteTrain();
        train.setLocomotive(new ElectricLocomotive(2,3));
        for(int i = 0; i < 3;i++){
            Carriage carriage = new PassengerCarriage(i,i,i,i);
            train.addCarriage(carriage);
        }
        list.add(train);

        Iterator iterator = list.createIterator();

        assertEquals(true, iterator.hasNext());
        iterator.next();
        assertNotEquals(true, iterator.hasNext());
    }

    @Test
    public void next() {
        List list = new ArrayList();

        Train train = new CouchetteTrain();
        train.setLocomotive(new ElectricLocomotive(2,3));
        for(int i = 0; i < 3;i++){
            Carriage carriage = new PassengerCarriage(i,i,i,i);
            train.addCarriage(carriage);
        }
        list.add(train);

        Iterator iterator = list.createIterator();
        assertEquals(train, iterator.next());
    }
}