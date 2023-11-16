

public class WorkShopError {

    public static void main(String[] args){
        WorkShop<PersCar> workshop = new WorkShop(6);
        Saab95 saab95 = new Saab95();
        workshop.IntakeCar(saab95);
        Volvo240 volvo = new Volvo240();
        workshop.IntakeCar(volvo);




    }
}
