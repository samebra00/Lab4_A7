package lab2;

import lab1.PersCar;

import java.awt.*;
import java.util.ArrayList;
// Extendar lab2.TRUCK bara för att markera att en Car Transport inte är en Personal Car
public class CarTransport extends TRUCK{

    private int LoadMAX;
    //Deklarerar att Transporten bara tar emot Personal Cars
    private ArrayList<PersCar> curLoad;
    //Inom vilket område Transporten kan lasta på bilar.
    private int loadingfield = 3;

            

    public CarTransport() {
        super(2, 570, 4000, Color.green, "CarTransport", 6);


    }
    // MAssa IF statements som kollar att bilen är nog nära Trucken i både X pos och Y pos.
    //Vi kollar även att bilen inte redans finns på listen och att maxload inte är uppnådd.DSADASD
   public void Load(PersCar car) {
         if (getRampState() == 0 && Math.abs(car.getXPos()) - Math.abs(this.getXPos()) < loadingfield
          && Math.abs(this.getYPos()) - Math.abs(car.getYPos()) < loadingfield && !curLoad.contains((car))) {
             if (curLoad.size() < LoadMAX){
                   curLoad.add(car);

         }
   }}


    //Returnerar alla bilar på Transporten
    public ArrayList getLoad(){;
        return curLoad;}


    //Använder move() från Cars eftersom Trucken kommer röra sig på samma sätt
    //I for loopen ser vi bara till att alla bilar på Lasten kommer uppdatera dess position till samma
    //som trucken.
     public void TruckMove(){
        move();
        for(PersCar i : curLoad){
            i.setXpos(this.getXPos());
            i.setYpos(this.getYPos());
        }
     }
     // Kollar så att rampen är nere och bilen står still. Hittar först de sista indexet i listan.
    //Hämtar bilen med funktionen get så att vi kan flytta på dess position
    //Tar bort bilen och uppdaterar dess position.
   public void UnloadOrder(){
        if(getRampState() == 0 && this.getCurrentSpeed() == 0){
            int idx = curLoad.size() - 1;
            PersCar unloadcar = curLoad.get(idx);
            curLoad.remove(idx);
            unloadcar.setXpos(this.getXPos() - 1);
            unloadcar.setYpos(this.getYPos() - 1);
        }

   }
}




