package Lab3;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;
import lab1.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    Application app;
    // Just a single image, TODO: Generalize
    HashMap<Cars, BufferedImage> images = new HashMap<>();

    // To keep track of a singel cars position
    ArrayList<Cars> cars = new ArrayList<>();

    ArrayList<Observer> observers = new ArrayList<>();


    // TODO: Make this genereal for all cars
    void moveit(double x,double y, Cars car){
        // Point newPos = new Point(x,y);
        car.setXpos(x);
        car.setYpos(y);
    }

    void createPoints(Collection<Cars> cars){
        int x = 0;
        for (Cars car : cars){
            car.setXpos(x);
            x += 100;
            x++;
        }


    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Collection<Cars> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        createPoints(cars);
        // Print an error message in case file is not found with a try/catch block
        try {
            for(Cars bil : cars){
                images.put(bil, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" +bil.getModelName()+".jpg")));
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public void updatePICS(Collection<Cars> cars){
        images.clear();
        createPoints(cars);
        if (cars.size() >= 1){
        try {

            for(Cars bil : cars){
                images.put(bil, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" +bil.getModelName()+".jpg")));
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }} else{
            images.clear();}
        repaint();
        }



    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (images.size() > 0){
        for (Cars car : images.keySet()) {
            g.drawImage(images.get(car),car.getPos().x,car.getPos().y, null); // see javadoc for more info on the parameters
        }} else{
            super.paintComponent(g);

        }
    }

}
