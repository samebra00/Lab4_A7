import java.awt.*;
import java.util.ArrayList;

public abstract class TRUCK extends Cars {
    private double WeightFactor = 0.2;

    public double RampState = 0;
    private int LoadMax;

    private ArrayList<PersCar> curLoad;



    public TRUCK(int nrDoors, double enginePower, double carWeight,Color color, String modelName, int LoadMax){
        super(nrDoors, enginePower, carWeight, color, modelName);
        this.LoadMax = LoadMax;
        this.curLoad = new ArrayList<PersCar>();
    }
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.1 * WeightFactor;
}


    @Override
    public void startEngine(){
        if (RampState == 0){
            setCurrentSpeed(0.1);
        }
    }


    public void RaiseAngle(){
        if (RampState == 0 && getCurrentSpeed() == 0){
            RampState = 70;
        }
    }

    public void LowerAngle(){
        if (RampState == 70 && getCurrentSpeed() == 0){
            RampState = 0;
        }
    }

    public double getRampState(){return RampState;}
}


