import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends TRUCK{

    private int LoadMAX;

    private ArrayList<PersCar> curLoad;

    private int loadingfield = 5;

            

    public CarTransport(int LoadMAX) {
        setNrDoors(2);
        setEnginePower(570);
        setCarWeight(4000);
        setColor(Color.green);
        setModelName("CarTransport");
        this.LoadMAX = LoadMAX;
        this.curLoad = new ArrayList();


    }
   public void Load(PersCar car) {
         if (getRampState() == 0 && Math.abs(car.getXPos()) - Math.abs(this.getXPos()) < loadingfield
          && Math.abs(this.getYPos()) - Math.abs(car.getYPos()) < loadingfield && !curLoad.contains((car))) {
             if (curLoad.size() < LoadMAX){
                   curLoad.add(car);

         }
   }}


    public ArrayList getLoad(){
        return curLoad;}



     public void TruckMove(){
        move();
        for(PersCar i : curLoad){
            i.setXpos(this.getXPos());
            i.setYpos(this.getYPos());
        }
     }
   public void UnloadOrder(){
        if(getRampState() == 0 && this.getCurrentSpeed() == 0){
            int idx = curLoad.size() - 1;
            PersCar unloadcar = curLoad.get(idx);
            curLoad.remove(idx);
            unloadcar.setXpos(this.getXPos() - 1);
            unloadcar.setYpos(this.getYPos() - 1);
        }

   }
}}




