import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class CarTransportTest extends TestCase {
    private  CarTransport CarTransport;
    @Before
    public void init(){CarTransport = new CarTransport(8);}
    @Test
    public void testRaiseAngle() {
        assert CarTransport.getRampState() == 0;
        CarTransport.gas(0.7);
        assert CarTransport.getRampState() == 0;
        CarTransport.stopEngine();
        CarTransport.RaiseAngle();
        assert CarTransport.getRampState() == 70;
        CarTransport.gas(0.6);
        CarTransport.move();
        CarTransport.LowerAngle();
        assert CarTransport.getRampState() == 70;

    }

    public void testLowerAngle() {
        assert CarTransport.getRampState() == 70;
        CarTransport.gas(0.5);
        assert CarTransport.getRampState() == 70;
        CarTransport.gas(0);
        CarTransport.LowerAngle();
        assert CarTransport.getRampState() == 0;
    }
    public void Load(){

        assert CarTransport.getLoad().isEmpty();
        Saab95 saab = new Saab95();
        CarTransport.Load(saab);
        assertFalse(CarTransport.getLoad().isEmpty());
        assert saab.getYPos() == 0;
        assert saab.getXPos() == 0;
        assert CarTransport.getXPos() == 0;
        assert CarTransport.getYPos() == 0;
        CarTransport.gas(0.8);
        // definition of moving forward
        CarTransport.move();
        // y should change not x
        assert saab.getXPos() != saab.getYPos();
        assert CarTransport.getYPos() == saab.getYPos();
        CarTransport.turnLeft();
        assert CarTransport.getXPos() !=0;
        assert saab.getXPos() == CarTransport.getXPos();




    }
    public void testGetRampState() {
        CarTransport.gas(0);
        assert CarTransport.getRampState() == 0;
        CarTransport.gas(0.8);
        CarTransport.RaiseAngle();
        assert CarTransport.getRampState() == 0;
    }

    public void testTruckMove() {

        CarTransport.setXpos(0);
        CarTransport.setYpos(0);

        CarTransport.move();
        assert CarTransport.getYPos() != 0;

    }
        public void testUnloadOrder() {
            CarTransport.UnloadOrder();
            assertTrue(CarTransport.getLoad().isEmpty());
            assert CarTransport.getRampState() ==0;
            CarTransport.gas(0);
            Volvo240 volvo = new Volvo240();
            Saab95 saab = new Saab95();
            CarTransport.Load(volvo);
            CarTransport.Load(saab);
            assert CarTransport.
        }
    }
    }
}