package Lab3;

import lab1.Cars;
import lab1.Saab95;
import lab2.Scania;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarController {


    private static final int delay = 50;

    ViewObserver observer = new ViewObserver();
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Cars> cars = new ArrayList<>();

    public Timer timer = new Timer(delay, new TimerListener());


    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : cars) {
                car.move();
                int x = (int) Math.round(car.getXPos());
                int y = (int) Math.round(car.getYPos());
                if (y <0 ){
                    car.turnRight();
                    car.turnRight();
                }
                if (y > 500 ){
                    car.turnLeft();
                    car.turnLeft();
                }
                // repaint() calls the paintComponent method of the panel
                observer.update();
            }
        }
    }


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Cars car : cars){
            car.gas(gas);
        }
    }
    void brake(double amount){
        double brake = amount/100;
        for(Cars car : cars){
            car.brake(brake);
        }

    }

    void startAllCars(){
        for (Cars car: cars){
            car.startEngine();
        }
    }
    void stopAllCars(){
        for (Cars car : cars){
            car.stopEngine();
        }
    }
    void SaabTurboOn(){
        for (Cars bil : cars){
            if (bil instanceof Saab95){
                ((Saab95) bil).setTurboOn();

            }
        }
    }
    void SaabTurboOff(){
        for (Cars bil : cars){
            if (bil instanceof Saab95){
                ((Saab95) bil).setTurboOff();

            }
        }
    }
    void ScaniaBedUp(){
        for (Cars bil : cars){
            if (bil instanceof Scania){
                ((Scania) bil).RaiseAngle(70);
            }
        }
    }
    void ScaniaBedDown(){
        for (Cars bil : cars){
            if (bil instanceof Scania){
                ((Scania) bil).LowerAngle(70);
            }
        }
    }
}
