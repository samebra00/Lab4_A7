package Lab3;

import lab1.Cars;

import java.util.ArrayList;
import java.util.Collection;

public class ViewObserver implements Observer {

    DrawPanel frame;

   ArrayList<Cars> cars = new ArrayList<>();

    @Override
    public  void update() {
        for (Cars car : cars) {
            int x = (int) Math.round(car.getXPos());
            int y = (int) Math.round(car.getYPos());
            frame.moveit(x, y, car);
            frame.repaint();


        }
    }}
