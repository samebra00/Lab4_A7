import java.awt.*;

public class Saab95 extends Cars {

    private boolean turboOn;
    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        xpos = 0;
        ypos = 0;
        dir = 0;
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }


    protected double speedFactor(){
        double turbo = 1.0;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }



}
