package Lab3;

import lab1.*;
import lab2.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class Application {
    private ModelTranslator MT;
    private CarView CW;


    private static final int delay = 50;

    private Timer timer;
    private CarController cc;

    public static void main(String[] args) {
        Application app = new Application();
        app.initApp();
        int x = (int) 0.1;
        System.out.print(x);
    }

    public void initApp(){
        ArrayList<Cars> cars = new ArrayList<>();
        this.MT = new ModelTranslator(cars);
        this.MT.initCars();
        this.CW = new CarView("CarSim1.0", MT);
        this.cc = new CarController(CW, MT);
        this.timer = new Timer(delay, new TimerListener());
        this.timer.start();
    }

    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : MT.cars) {
                car.move();
                double x = car.getXPos();
                double y = car.getYPos();
                if (y < 0) {
                    car.turnRight();
                    car.turnRight();
                }
                if (y > 500) {
                    car.turnLeft();
                    car.turnLeft();
                }
                CW.drawPanel.moveit(x, y, car);
                CW.drawPanel.repaint();

            }
        }
    }

}

