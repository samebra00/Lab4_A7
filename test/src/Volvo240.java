import java.awt.*;

public class Volvo240 extends PersCar{

    private final static double trimFactor = 1.25;
    public Volvo240() {
        setNrDoors(4);
        setEnginePower(100);
        setCarWeight(1243);
        setColor(Color.black);
        setModelName("Volvo240");
        stopEngine();
    }

    protected double speedFactor(){ return getEnginePower() * 0.01 * trimFactor;}





    }



