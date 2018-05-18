interface Train{
    //region Methods
    void addCarriage(Carriage newCarriage);
    void sort();
    // Returns first Carriage where amount of passengers are greater or equal than min and less or equal than max
    Carriage findCarPassengerRange(int min, int max);

    int calcPassengerSum();
    int calcBaggageSum();
    //endregion

    //region Getters and Setters
    Carriage[] getCarriages();
    Locomotive getLocomotive();
    int        getCarriageCount();

    void       setLocomotive(Locomotive locomotive);
    void       setCarriages(Carriage[] carriages);
    //endregion
}