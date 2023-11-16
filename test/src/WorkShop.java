
import java.security.DrbgParameters;
import java.util.ArrayList;

public class WorkShop<T> {

    private int Cap;
    private double loadposx = 0;

    private ArrayList<T> Stallet;

    public WorkShop(int Cap) {
        this.Cap = Cap;
    }

    public void IntakeCar(T car) {

        if (Stallet.size() < this.Cap) {
            Stallet.add(car);
        }

    }

    public Cars outTake(Cars car) {
         double loadposx = 0;
        Stallet.remove(car);
        car.setXpos(loadposx);
        loadposx += 1;
        return car;
        }


    }
