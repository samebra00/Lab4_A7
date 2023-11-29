package lab2;

import lab1.*;

// Klass för att kontrollera statiska kompileringsfel för WorkShop.
public class WorkShopError {

    public static void main(String[] args){
        WorkShop<PersCar> workshop = new WorkShop(2);
        Saab95 saab95 = new Saab95();
        Volvo240 volvo = new Volvo240();
        volvo.getModelName();





    }
}
