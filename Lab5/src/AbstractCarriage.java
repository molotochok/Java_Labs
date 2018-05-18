public abstract class AbstractCarriage implements Carriage{

    private int index;

    private int passengerCount;
    private int baggageCount;

    private int levelOfComfort;


    //region Constructor
    AbstractCarriage(){
        initializeValues(0, 0, 0, 0);

    }
    AbstractCarriage(int index, int passengerCount, int baggageCount, int levelOfComfort){
        initializeValues(index, passengerCount, baggageCount, levelOfComfort);
    }
    //endregion

    //region Methods
    @Override
    public void initializeValues(int index, int passengerCount, int baggageCount, int levelOfComfort) {
        setIndex(index);
        setPassengerCount(passengerCount);
        setBaggageCount(baggageCount);
        setLevelOfComfort(levelOfComfort);
    }

    @Override
    public String toString() {
        String result = "-------- Carriage " + index + " --------\n";
        result += "Passenger count: "   + passengerCount    + "\n" +
                  "Baggage count: "     + baggageCount      + "\n" +
                  "Level of comfort: "  + levelOfComfort    + "\n" ;
        result += "----------------------------\n";
        return result;
    }
    //endregion

    //region Getters and Setters
    @Override
    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
    @Override
    public void setBaggageCount(int baggageCount) {
        this.baggageCount = baggageCount;
    }
    @Override
    public void setLevelOfComfort(int levelOfComfort) {
        this.levelOfComfort = levelOfComfort;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int getPassengerCount() {
        return passengerCount;
    }
    @Override
    public int getBaggageCount() {
        return baggageCount;
    }
    @Override
    public int getLevelOfComfort() {
        return levelOfComfort;
    }

    @Override
    public int getIndex() {
        return index;
    }
    //endregion
}
