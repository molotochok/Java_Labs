package com.company.TrainHierarchy;

public abstract class AbstractTrain implements Train{

    private Carriage[] carriages;
    private Locomotive locomotive;
    private int carriageCount;

    // Constructors
    AbstractTrain(){
        setLocomotive(null);
        setCarriages(new Carriage[0]);
    }
    AbstractTrain(Locomotive locomotives, Carriage[] carriages){
        setLocomotive(locomotive);
        setCarriages(carriages);
    }

    //region public Methods
    @Override
    public void addCarriage(Carriage newCarriage){
        int previousSize = carriageCount;
        carriageCount++;
        Carriage[] newCarriages = new Carriage[carriageCount];
        for(int i = 0;i < previousSize; i++){
            newCarriages[i] = carriages[i];
        }
        newCarriages[carriageCount - 1] = newCarriage;

        carriages = newCarriages;
    }

    @Override
    public void sort() {
        for(int i = 0; i < carriageCount - 1;i++) {
            for (int j = 0; j < carriageCount - 1; j++) {
                if (carriages[j].getLevelOfComfort() > carriages[j+1].getLevelOfComfort()){
                    Carriage tempCarriage = carriages[j];
                    carriages[j] = carriages[j + 1];
                    carriages[j + 1] = tempCarriage;
                }
            }
        }
    }

    @Override
    public Carriage findCarPassengerRange(int min, int max) {
        for(int i = 0;i < carriageCount; i++) {
            if(carriages[i].getPassengerCount() >= min && carriages[i].getPassengerCount() <= max){
                return carriages[i];
            }
        }
        return null;
    }

    @Override
    public int calcPassengerSum() {
        int sum = 0;
        for(int i = 0; i < carriageCount; i++){
            sum += carriages[i].getPassengerCount();
        }
        return sum;
    }
    @Override
    public int calcBaggageSum() {
        int sum = 0;
        for(int i = 0; i < carriageCount; i++){
            sum += carriages[i].getBaggageCount();
        }
        return sum;
    }
    //endregion

    //region Override Object methods
    @Override
    public String toString() {
        String out = "\nTrain:\n";
        out += locomotive.toString();
        for(int i = 0;i < carriageCount;i++){
            out += carriages[i].toString();
        }
        out+="\n";
        return out;
    }
    //endregion

    //region Getters and Setters
    @Override
    public Carriage[] getCarriages() {
        return carriages;
    }
    @Override
    public Locomotive getLocomotive(){
        return locomotive;
    }
    @Override
    public int getCarriageCount(){
        return carriageCount;
    }

    @Override
    public void setCarriages(Carriage[] carriages) {
        this.carriages     = carriages;
        this.carriageCount = carriages.length;
    }
    @Override
    public void setLocomotive(Locomotive locomotive){
        this.locomotive = locomotive;
    }
    //endregion
}
