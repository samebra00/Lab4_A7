package Lab3;

import lab1.*;
import lab2.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class Application {

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        ModelTranslator MT = new ModelTranslator();



        MT.cars.add(CarFactory.createVolvo240());
        MT.cars.add(CarFactory.createSaab95());
        MT.cars.add(CarFactory.createScania());

        // Start a new view and send a reference of self
        cc.CW = new CarView("CarSim1.0", MT);
        cc.MT = MT;
        cc.initButtons();

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */


    // Calls the gas method for each car once

}

