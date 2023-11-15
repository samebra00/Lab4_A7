import java.awt.*;

public class Saab95 extends PersCar {

    private boolean turboOn;
    public Saab95() {
        setNrDoors(2);
        setEnginePower(125);
        setCarWeight(1479);
        setColor(Color.red);
        setModelName("Saab95");
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedFactor(){
        double turbo = 1.0;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }



}
