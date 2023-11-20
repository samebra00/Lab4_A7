import java.awt.*;

public class Scania extends TRUCK {


    private double WeightFactor;

    public Scania(){
        super(2, 100, 3000, Color.blue, "Scania ", 1);

    }

    public void RaiseAngle(double amount){
        if ((RampState + amount) <= 70 && RampState + amount >= 0 && getCurrentSpeed() ==0){
        RampState += amount;}
    }

    public void LowerAngle(double amount){
        if ((RampState - amount) > 0 && RampState - amount >= 70 && getCurrentSpeed() ==0){
        RampState -= amount;}
    }



}
