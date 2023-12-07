package Lab3;

import lab1.*;
import lab2.*;

public class CarFactory {



    public static Volvo240 createVolvo240(){
        return new Volvo240();
    }

    public static Saab95 createSaab95(){return new Saab95();}


    public static Scania createScania(){return new Scania();}
}
