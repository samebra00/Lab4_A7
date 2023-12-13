package Lab3;

import lab1.*;
import lab2.Scania;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class ModelTranslator{


    HashMap<Cars, Point> carPoints = new HashMap<>();

    ArrayList<Observer> observers = new ArrayList<>();

    ArrayList<Cars> cars;

    Random rd = new Random();
    public ModelTranslator(ArrayList<Cars> cars){
        this.cars = cars;
    }



    void initCars(){
        this.cars.add(CarFactory.createVolvo240());
        this.cars.add(CarFactory.createSaab95());
        this.cars.add(CarFactory.createScania());
    }


    void addVolvo240(){
        this.cars.add(CarFactory.createVolvo240());
    }

    void addSaab95(){
        this.cars.add(CarFactory.createSaab95());
    }

    void addScania(){
       this.cars.add(CarFactory.createScania());
    }

    void removeCar(){
        if (this.cars.size() == 1){
           this.cars.clear();
        } else if(this.cars.size()>1){
            int rand_int = rd.nextInt(this.cars.size());
            this.cars.remove(rand_int);
        }
    }


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Cars car : this.cars){
            car.gas(gas);
            System.out.println("GAAS");
        }
    }
    void brake(double amount){
        double brake = amount/100;
        for(Cars car : this.cars){
            car.brake(brake);
        }

    }

    void startAllCars(){

        for (Cars car: this.cars){
            if(car.getCurrentSpeed() == 0){
            car.startEngine();
            System.out.println("BLASASDASAS");
        }
    }}
    void stopAllCars(){
        for (Cars car : this.cars){
            if(car.getCurrentSpeed()>0){
            car.stopEngine();}
        }
    }
    void SaabTurboOn(){
        for (Cars bil : this.cars){
            if (bil instanceof Saab95){
                ((Saab95) bil).setTurboOn();

            }
        }
    }
    void SaabTurboOff(){
        for (Cars bil :this.cars){
            if (bil instanceof Saab95){
                ((Saab95) bil).setTurboOff();

            }
        }
    }
    void ScaniaBedUp(){
        for (Cars bil : this.cars){
            if (bil instanceof Scania){
                ((Scania) bil).RaiseAngle(70);
            }
        }
    }
    void ScaniaBedDown(){
        for (Cars bil : this.cars){
            if (bil instanceof Scania){
                ((Scania) bil).LowerAngle(70);
            }
        }
    }



    }

