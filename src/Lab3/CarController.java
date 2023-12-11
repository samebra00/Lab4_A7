package Lab3;

import lab1.Cars;
import lab1.Saab95;
import lab2.Scania;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarController {


    private static final int delay = 50;

     Timer timer = new Timer(delay, new TimerListener());

     CarView CW;

     ModelTranslator MT;







    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : MT.cars) {
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
               CW.drawPanel.moveit(x, y , car);
                CW.drawPanel.repaint();
                // repaint() calls the paintComponent method of the panel
            }
        }
    }

    public void initButtons(){

        CW.gasSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                CW.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });


        CW.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MT.gas(CW.gasAmount);
            }


        });

        CW.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MT.brake(CW.gasAmount);
            }
        });
        CW.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MT.startAllCars();
            }
        });

        CW.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MT.stopAllCars();
            }
        });
        CW.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MT.ScaniaBedDown();
            }
        });
        CW.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MT.ScaniaBedUp();
            }
        });
        CW.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MT.SaabTurboOn();
            }
        });

        CW.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MT.SaabTurboOff();
            }
        });
    }
}
