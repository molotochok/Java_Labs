package com.company;

import com.company.List.ArrayList;
import com.company.List.Iterator;
import com.company.List.List;
import com.company.TrainHierarchy.Train;

import java.io.*;

public class FileManager {
    private static final String DIR_PATH = "C:\\Users\\Markiian\\Desktop\\Learning\\Second course\\Second\\Java\\Labs\\Lab8\\";

    private String filePath;

    public FileManager(String filePath){
        this.filePath = filePath;
    }

    // --1-- Save and Load List as one object
    public void saveObject(List list) throws IOException{
        try{
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);

            fos.close();
        }catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public List loadObject() throws IOException{
        List list = new ArrayList();
        try{
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List)ois.readObject();
            fis.close();
        } catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    // --2-- Save and Load Trains as sequence object
    public void saveTrains(List list) throws IOException{
        try{
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream ois = new ObjectOutputStream(fos);

            Iterator iterator = list.createIterator();
            while(iterator.hasNext()){
                ois.writeObject(iterator.next());
            }
            fos.close();
        }catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public List loadTrains() throws IOException{
        List<Train> list = new ArrayList();
        try{
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while(true){
                try{
                    list.add((Train)ois.readObject());
                }catch(EOFException ex){
                    break;
                }
            }
            fis.close();
        } catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    // --3-- Save and Load Objects as text
    public void saveObjectAsText(List list) throws IOException{
        try {
            FileWriter fileWriter = new FileWriter(filePath);

            Iterator iterator = list.createIterator();
            while(iterator.hasNext()){
                fileWriter.write(iterator.next().toString());
            }
            fileWriter.flush();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public String loadObjectAsText() throws IOException{
        String result = "";
        try {
            FileReader fileReader = new FileReader(filePath);

            int c;
            while((c = fileReader.read()) != -1){
                result += ((char)c);
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
