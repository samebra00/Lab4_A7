import java.awt.*;

public class Scania extends TRUCK {

    private double TrailerAngle;

    private double WeightFactor;

    public Scania(){
        setNrDoors(2);
        setEnginePower(1000);
        setCarWeight(3000);
        setColor(Color.blue);
        setModelName("Scania");
        this.TrailerAngle = 0;
        this.WeightFactor = 0.3;
    }

    @Override
    public void startEngine(){
        if (TrailerAngle == 0){
            setCurrentSpeed(0.1);
        }
    }



    public void RaiseAngle(double amount){
        if ((TrailerAngle + amount) <= 70 && TrailerAngle + amount >= 0 && getCurrentSpeed() ==0){
        TrailerAngle += amount;}
    }

    public void LowerAngle(double amount){
        if ((TrailerAngle - amount) > 0 && TrailerAngle - amount >= 70 && getCurrentSpeed() ==0){
        TrailerAngle -= amount;}
    }

    public double getTrailerAngle(){
        return TrailerAngle;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.1 * WeightFactor;
    }
}
