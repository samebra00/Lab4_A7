package Lab3;

import lab1.Cars;

import java.util.ArrayList;

import java.util.Collection;

public class ViewObserver implements Observer {

    CarView CW;

    ModelTranslator MT;

    //CarController cc;


    @Override
    public void update() {
        for (Cars car : MT.cars) {
            int x = (int) Math.round(car.getXPos());
            int y = (int) Math.round(car.getYPos());
            CW.drawPanel.moveit(x, y, car);
            CW.drawPanel.repaint();



        }
    }}
