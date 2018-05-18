package com.company.TrainHierarchy;

public class AbstractLocomotive implements Locomotive {

    public static String type;
    private int power;
    private int maxSpeed;

    //region Constructors
    AbstractLocomotive(){
        setPower(0);
        setMaxSpeed(0);
    }
    AbstractLocomotive(int power, int maxSpeed){
        setPower(power);
        setMaxSpeed(maxSpeed);
    }
    //endregion


    @Override
    public String toString() {
        String result = "-------- Locomotive --------\n";
        result += "Name: "      + type     + "\n" +
                  "Max Speed: " + maxSpeed + "\n" +
                  "Power: "     + power    + "\n";
        result += "--------------------------\n";
        return result;
    }

    //region Getter and Setter
    @Override
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }
    //endregion
}
