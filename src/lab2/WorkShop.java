package lab2;

import lab1.Cars;
import lab1.PersCar;

import java.util.ArrayList;
// T extends cars betyder att Typargumentet Saab95 eller Volvo240 kommer ärva metoder från cars.
//även om dom typerna per automatik ärver från Cars måste detta deklareras i denna kod för att
// input av typ T i outTake ska ha tillgång till Cars metoder.
public class WorkShop<T extends Cars> {

    private int Cap;
    private double loadposx = 0;

    private ArrayList<T> Stallet = new ArrayList<>(0);

    public WorkShop(int Cap) {
        this.Cap = Cap;
    }

    public void IntakeCar(T car) {

        if (Stallet.size() < this.Cap) {
            Stallet.add(car);
        }
        else{
        System.out.println("Workshop full, try the one down the street");}
    }


    public T outTake(T car) {
        Stallet.remove(car);
        car.setXpos(loadposx);
        loadposx ++;
        return car;
        }

    public ArrayList<T> curCars(){return Stallet;}

    }
