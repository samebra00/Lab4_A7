package Lab3;

import lab1.*;
import lab2.Scania;

import java.util.ArrayList;

public class ModelTranslator {

    ArrayList<Cars> cars = new ArrayList<>();



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
