package Lab3;

import lab1.Cars;
import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

public interface Observer {


    void update(HashMap<Cars, Point> carPoints, Collection<Cars> cars);
}
