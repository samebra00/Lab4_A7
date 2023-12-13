package lab1;

import java.awt.*;


public abstract class Cars implements Movable {

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private int dir = 0;
    private String modelName;
    private double xpos = 0, ypos = 0;







    public  Cars(int nrDoors, double enginePower,double carWeight, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xpos = 0;
        this.ypos = 0;
        this.dir = 0;
        this.currentSpeed = 0;
    }




    public String getModelName(){return this.modelName;}
    public int getNrDoors() {
        return this.nrDoors;
    }



    public double getEnginePower() {
        return enginePower;
    }




    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed){
        if(0 <= speed && speed <=0.1){
            currentSpeed = speed;
        }
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

    protected abstract double speedFactor();


    public void incrementSpeed(double amount) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }


    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    public double getXPos(){
        return xpos;
    }

    public void setXpos(double pos){
        this.xpos = pos;
    }

    public double getYPos(){
        return ypos;}



    public void setYpos(double pos){ this.ypos = pos;}

    public Point getPos(){
        int xpos = (int) this.xpos;
        int ypos = (int) this.ypos;
        return new Point(xpos, ypos);
    }

    public void move() {
        switch (getDir()) {
            case 0:
                ypos = ypos + getCurrentSpeed();
                break;
            case 1:
                xpos = xpos + getCurrentSpeed();
                break;
            case 2:
                ypos = ypos - getCurrentSpeed();
                break;
            case 3:
                xpos = xpos - getCurrentSpeed();
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
        if(0 <= amount && amount <=1 && currentSpeed >= 0.1){
        incrementSpeed(amount);}
        }


    // TODO fix this method according to lab pm
    public void brake(double amount) {
        if(0 <= amount && amount <=1){
        decrementSpeed(amount);}
    }}
