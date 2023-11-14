import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Cars{

    private boolean RampState;
    private double WeightFactor = 0.2;

    private int LoadMAX;

    private ArrayList<Cars> LoadCap;



    public CarTransport(int nrDoors, double enginePower,double carWeight, Color color, String modelName,int LoadMAX){
        super(nrDoors, enginePower,carWeight,color,modelName);
        this.LoadMAX = LoadMAX;
        this.LoadCap = new ArrayList(this.LoadMAX);
        





    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.1 * WeightFactor;
    }

    public void RampUp() {
        if (!RampState) {
            RampState = true;
        }
    }

    public void RampDown(){
            if (RampState && getCurrentSpeed() == 0){
                RampState = false;
            }
        }







   private void ValidLoad(Cars car) {

       this.car = Car;
       if (car.getCarWeight() < 2000 && RampDown() == True) {

       }
   }
   private UnloadOrder(){

   }
}




