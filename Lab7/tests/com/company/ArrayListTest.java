package com.company;

import com.company.Exceptions.ArrayIndexOutOfBoundsException;
import com.company.TrainHierarchy.AbstractTrain;
import com.company.TrainHierarchy.CouchetteTrain;
import com.company.TrainHierarchy.FreightTrain;
import com.company.TrainHierarchy.Train;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void size() {
        ArrayList arrayList = new ArrayList();

        assertEquals(0, arrayList.size());

        for(int i = 0; i< 100;i++){
            AbstractTrain newTrain = new CouchetteTrain();
            arrayList.add(newTrain);
        }

        assertEquals(100, arrayList.size());
    }

    @Test
    public void isEmpty() {
        ArrayList arrayList = new ArrayList();

        assertEquals(true, arrayList.isEmpty());

        for(int i = 0; i< 10;i++){
            AbstractTrain newTrain = new CouchetteTrain();
            arrayList.add(newTrain);
        }

        assertEquals(false, arrayList.isEmpty());
    }

    @Test
    public void contains() {
        ArrayList arrayList = new ArrayList();
        AbstractTrain train = new CouchetteTrain();

        assertEquals(false, arrayList.contains(train));

        arrayList.add(train);

        assertEquals(true, arrayList.contains(train));
    }

    @Test
    public void add() {
        ArrayList arrayList = new ArrayList();
        AbstractTrain train = new CouchetteTrain();

        assertEquals(0, arrayList.size());

        arrayList.add(train);
        arrayList.add(train);
        arrayList.add(train);

        assertEquals(3, arrayList.size());
    }

    @Test
    public void clear() {
        ArrayList arrayList = new ArrayList();

        assertEquals(0, arrayList.size());

        AbstractTrain train = new CouchetteTrain();
        for(int i = 0;i<100;i++){
            arrayList.add(train);
        }

        arrayList.clear();
        assertNotEquals(100, arrayList.size());
        assertEquals(0, arrayList.size());
    }

    @Test
    public void get() throws ArrayIndexOutOfBoundsException{
        ArrayList arrayList = new ArrayList();
        AbstractTrain train = new CouchetteTrain();
        arrayList.add(train);

        assertEquals(train, arrayList.get(0));
    }


    @Test
    public void indexOf() {
        ArrayList arrayList = new ArrayList();
        AbstractTrain train1 = new CouchetteTrain();
        AbstractTrain train2 = new CouchetteTrain();

        arrayList.add(train1);
        arrayList.add(train2);

        assertEquals(1,arrayList.indexOf(train2));
        assertEquals(0,arrayList.indexOf(train1));
    }

    @Test
    public void setDescription() {
        ArrayList arrayList = new ArrayList();
        arrayList.setDescription("Description");

        assertEquals("Description", arrayList.getDescription());
    }

}