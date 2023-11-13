import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
public class Saab95Test{

    private Saab95 saab;

    @Before
    public void init(){
        saab = new Saab95();
    }

    @Test
    public void testGetNrDoors() {
        assert saab.getNrDoors() == 2;
    }
    @Test
    public void testGetEnginePower() {
        assert saab.getEnginePower() == 125;
    }
    @Test
    public void testGetCurrentSpeed() {
        assert saab.getCurrentSpeed() == 0;
    }
    @Test
    public void testGetColor() {
        assert saab.getColor() == Color.red;
    }
    @Test
    public void testSetColor() {
        saab.setColor(Color.black);
        assert saab.getColor() == Color.black;
    }
    @Test
    public void testGas(){
        saab.startEngine();
        double speed = saab.getCurrentSpeed();
        saab.gas(200);
        assertEquals(speed,saab.getCurrentSpeed(),0);

    }
    @Test
    public void testBrake(){
        double speed = saab.getCurrentSpeed();
        saab.brake(200);
        assertEquals(speed, saab.getCurrentSpeed(), 0);
    }
    @Test
    public void testStartEngine() {
        saab.startEngine();
        assert saab.getCurrentSpeed() >= 0.1;
    }
    @Test
    public void testStopEngine() {
        saab.stopEngine();
        assert saab.getCurrentSpeed() == 0;
    }
    @Test
    public void testSpeedFactor() {
       saab.setTurboOn();
       assert saab.speedFactor() == 125 * 0.01 * 1.3;

       saab.setTurboOff();
       assert saab.speedFactor() == 125 * 0.01 * 1;

    }
    @Test
    public void testIncrementSpeed() {
        double speed = saab.getCurrentSpeed();
        saab.incrementSpeed(10.0);
        assert saab.getCurrentSpeed() == Math.min(speed + saab.speedFactor() * 10, saab.getEnginePower());

    }
    @Test
    public void testDecrementSpeed() {
        double speed = saab.getCurrentSpeed();
        saab.decrementSpeed(10);
        assert saab.getCurrentSpeed() == Math.max(speed - saab.speedFactor() * 10,0);
    }

    @Test
    public void testGetDir(){
        assert saab.getDir() == 0;}

    @Test
    public void testMove() {
            saab.startEngine();
            saab.move();
            assert saab.getXPos() == 0;
            assert saab.getYPos() == 0.1;
            saab.turnRight();
            saab.move();
            assert saab.getXPos() == 0.1;
            assert saab.getYPos() == 0.1;
            saab.turnLeft();
            saab.move();
            assert saab.getXPos() == 0.1;
            assert saab.getYPos() == 0.2;

    }
    @Test
    public void testTurnLeft() {
        saab.turnRight();
        assert saab.getDir() == 1;
        saab.turnRight();
        assert saab.getDir() == 2;
        saab.turnRight();
        assert saab.getDir() == 3;
        saab.turnRight();
        assert saab.getDir() == 0;
    }
    @Test
    public void testTurnRight() {
        saab.turnLeft();
        assert saab.getDir() == 3;
        saab.turnLeft();
        assert saab.getDir() == 2;
        saab.turnLeft();
        assert saab.getDir() == 1;
        saab.turnLeft();
        assert saab.getDir() ==0;
    }


}