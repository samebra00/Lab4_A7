package Lab3;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;
import lab1.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    HashMap<Cars, BufferedImage> images = new HashMap<>();

    // To keep track of a singel cars position
    HashMap<Cars, Point> carPoints = new HashMap<>();

    BufferedImage backgroundImage;


    // TODO: Make this genereal for all cars
    void moveit(int x, int y, Cars car){
        Point newPos = new Point(x,y);
        carPoints.replace(car, newPos);
    }

    HashMap<Cars, Point> createPoints(Collection<Cars> cars){
        HashMap<Cars, Point> hash = new HashMap<>();
        int x = 0;
        for (Cars car : cars){
            hash.put(car, new Point(x, 0));
            car.setXpos(x);
            x += 200;
        }
        return hash;

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Collection<Cars> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carPoints = createPoints(cars);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
           /* volvoImage = ImageIO.read(Lab3.DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(Lab3.DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(Lab3.DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));*/

            for(Cars bil : cars){
                images.put(bil, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" +bil.getModelName()+".jpg")));
            }
        } catch (IOException ex)
        {System.out.println("Ingen fil med det namnet hittades");
            //ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Cars bil : images.keySet()) {
            g.drawImage(images.get(bil), carPoints.get(bil).x, carPoints.get(bil).y, null); // see javadoc for more info on the parameters
        }
    }
}
