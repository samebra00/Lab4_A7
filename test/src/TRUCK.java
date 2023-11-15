public abstract class TRUCK extends Cars{
    private double WeightFactor = 0.2;

    private double RampState = 0;

    protected double speedFactor() {
        return getEnginePower() * 0.1 * WeightFactor;
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


