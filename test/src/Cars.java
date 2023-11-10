import java.awt.*;
import java.util.ArrayList;

public abstract class Cars implements Movable {

    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;

    protected int dir = 0;
    protected String modelName;
    protected double xpos = 0, ypos = 0;

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }


    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;

    }
    public int getDir() {
        return dir;
    }

    abstract double speedFactor();


    public void incrementSpeed(double amount) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }


    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    public double getXPos(){return xpos;}

    public double getYPos(){return ypos;}

    public void move() {
        switch (getDir()) {
            case 0:
                ypos = getYPos() + getCurrentSpeed();
                break;
            case 1:
                xpos = getXPos() + getCurrentSpeed();
                break;
            case 2:
                ypos = getYPos() - getCurrentSpeed();
                break;
            case 3:
                xpos = getXPos() - getCurrentSpeed();
                break;


        }
    }


        public void turnLeft() {
            if (dir == 0) {
                dir = 3;
            } else {
                dir = dir - 1;
            }
        }


        public void turnRight() {
            if (dir == 3) {
                dir = 0;
            } else {
                dir = dir + 1;
            }
        }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        if(0 <= amount && amount <=1){
        incrementSpeed(amount);}
        }


    // TODO fix this method according to lab pm
    public void brake(double amount) {
        if(0 <= amount && amount <=1){
        decrementSpeed(amount);}
    }}
