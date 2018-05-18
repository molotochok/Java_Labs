package com.company;

import com.company.List.ArrayList;
import com.company.List.List;
import com.company.TrainHierarchy.CouchetteTrain;
import com.company.TrainHierarchy.ElectricLocomotive;
import com.company.TrainHierarchy.PassengerCarriage;
import com.company.TrainHierarchy.Train;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class FileManagerTest {

    private static final String FILE_PATH = "C:\\Users\\Markiian\\Desktop\\Learning\\Second course\\Second\\Java\\Labs\\Lab8\\train.txt";

    List createList(){
        List list = new ArrayList();
        for(int i = 0;i<2;i++){
            Train train = new CouchetteTrain();
            train.setLocomotive(new ElectricLocomotive());
            train.addCarriage(new PassengerCarriage(2,3,4,2));
            list.add(train);
        }
        return list;
    }

    @Test
    public void saveLoadObject() throws IOException {
        FileManager fileManager = new FileManager(FILE_PATH);
        List list = createList();
        fileManager.saveObject(list);

        assertEquals(list.toString(), fileManager.loadObject().toString());
    }

    @Test
    public void saveLoadTrains() throws IOException {
        FileManager fileManager = new FileManager(FILE_PATH);
        List list = createList();
        fileManager.saveTrains(list);

        assertEquals(list.toString(), fileManager.loadTrains().toString());
    }


    @Test
    public void saveLoadObjectAsText() throws IOException {
        FileManager fileManager = new FileManager(FILE_PATH);
        List list = createList();
        fileManager.saveObjectAsText(list);

        assertEquals(list.toString(), fileManager.loadObjectAsText());
    }

}