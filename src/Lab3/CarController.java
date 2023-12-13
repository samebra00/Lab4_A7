package Lab3;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class CarController {
    Random rd = new Random();


     private CarView CW;

     private ModelTranslator MT;


    public CarController(CarView CW, ModelTranslator MT){
        this.MT = MT;
        this.CW = CW;
        initButtons();
    }

    public void initButtons(){

        CW.gasSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                CW.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        CW.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MT.cars.size() < 10){
                    int rand_int = rd.nextInt(3);

                    if (rand_int ==1){
                        MT.addSaab95();
                    }
                    else if (rand_int == 2){
                        MT.addVolvo240();
                    }
                    else{
                        MT.addScania();
                }}
                CW.drawPanel.updatePICS(MT.cars);
            }
        });

        CW.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MT.removeCar();
                    CW.drawPanel.updatePICS(MT.cars);}

        });



        CW.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MT.gas(CW.gasAmount);
                System.out.println("NICE");
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
                System.out.println("HEJSAN");
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
