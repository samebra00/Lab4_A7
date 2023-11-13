import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Volvo240Test {

    private Volvo240 volvo;

    @Before
    public void init(){
        volvo = new Volvo240();
    }
    @Test
    public void testGetNrDoors() {
        assert volvo.getNrDoors() == 4;

    }
    @Test
    public void testGetEnginePower() {
        assert volvo.getEnginePower() == 100;
    }
    @Test
    public void testGetCurrentSpeed() {
        assert volvo.getCurrentSpeed() == 0;
    }
    @Test
    public void testGetColor() {
        assert volvo.getColor() == Color.black;
    }
    @Test
    public void testSetColor() {
        volvo.setColor(Color.red);
        assert volvo.getColor() == Color.red;
    }
    @Test
    public void testStartEngine() {
        volvo.startEngine();
        assert volvo.getCurrentSpeed() >= 0.1;
    }
    @Test
    public void testStopEngine() {
        volvo.stopEngine();
        assert volvo.getCurrentSpeed() == 0;
    }
    @Test
    public void testSpeedFactor() {
        assert volvo.speedFactor() == 100 * 0.01 * 1.25;
    }
    @Test
    public void testIncrementSpeed() {
        double speed = volvo.getCurrentSpeed();
        volvo.incrementSpeed(10.0);
        assert volvo.getCurrentSpeed() == Math.min(speed + volvo.speedFactor() * 10, volvo.getEnginePower());
    }
    @Test
    public void testDecrementSpeed() {
        double speed= volvo.getCurrentSpeed();
        volvo.decrementSpeed(10.0);
        assert volvo.getCurrentSpeed() == Math.max(speed - volvo.speedFactor() * 10, 0);
    }

    @Test
    public void testGetDir(){
        assert volvo.getDir() == 0;

    }
    @Test
    public void testGas() {
        volvo.startEngine();
        double speed = volvo.getCurrentSpeed();
        volvo.gas(200);
        assertEquals(volvo.getCurrentSpeed(), speed, 0);
        volvo.gas(0.5);
        assertNotEquals(speed, volvo.getCurrentSpeed(), 0);

    }
    @Test
    public void testBrake() {
        volvo.gas(1);
        double speed = volvo.getCurrentSpeed();
        volvo.brake(100);
        assertEquals(volvo.getCurrentSpeed(), speed, 0);
        volvo.brake(0.5);
        assertNotEquals(speed, volvo.getCurrentSpeed(), 0);
    }
    @Test
    public void testMove() {
        volvo.startEngine();
        volvo.move();
        assert volvo.getXPos() == 0;
        assert volvo.getYPos() == 0.1;
        volvo.turnRight();
        volvo.move();
        assert volvo.getXPos() == 0.1;
        assert volvo.getYPos() == 0.1;
        volvo.turnLeft();
        volvo.move();
        assert volvo.getXPos() == 0.1;
        assert volvo.getYPos() == 0.2;


    }
    @Test
    public void testTurnRight() {
        volvo.turnRight();
        assert volvo.getDir() == 1;
        volvo.turnRight();
        assert volvo.getDir() == 2;
        volvo.turnRight();
        assert volvo.getDir() == 3;
        volvo.turnRight();
        assert volvo.getDir() == 0;

    }
    @Test
    public void testTurnLeft() {
        volvo.turnLeft();
        assert volvo.getDir() == 3;
        volvo.turnLeft();
        assert volvo.getDir() == 2;
        volvo.turnLeft();
        assert volvo.getDir() == 1;
        volvo.turnLeft();
        assert volvo.getDir() ==0;

    }
}