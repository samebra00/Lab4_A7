import java.util.ArrayList;

import static java.sql.DriverManager.println;
// Klass för att kontrollera statiska kompileringsfel för WorkShop.
public class WorkShopError {

    public static void main(String[] args){
        WorkShop<PersCar> workshop = new WorkShop(2);
        Saab95 saab95 = new Saab95();
        Volvo240 volvo = new Volvo240();
        workshop.IntakeCar(volvo);
        workshop.IntakeCar(saab95);
        Saab95 saab93 = new Saab95();
        workshop.IntakeCar(saab93);
        ArrayList str = workshop.curCars();
        System.out.println(str.toString());




    }
}
