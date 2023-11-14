import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ScaniaTest{
    private Scania Scania;
    @Before
    public void init(){Scania = new Scania();}
    @Test
    public void testRaiseAngle() {
        assert Scania.getTrailerAngle() == 0;
        Scania.gas(0.5);
        assert Scania.getTrailerAngle() == 0;
        Scania.stopEngine();
        Scania.RaiseAngle(30);
        assert Scania.getTrailerAngle() == 30;
        Scania.RaiseAngle( 50);
        assert Scania.getTrailerAngle() == 30;



    }
    @Test
    public void testLowerAngle() {
        assert Scania.getTrailerAngle() == 0;
        Scania.gas(0.5);
        assert Scania.getTrailerAngle() == 0;
        Scania.stopEngine();

        Scania.LowerAngle(30);
        assert Scania.getTrailerAngle() == 0;
        Scania.LowerAngle(10);
        assert Scania.getTrailerAngle() == 0;




    }
    @Test
    public void testGetTrailerAngle() {
        assert Scania.getTrailerAngle() == 0;

    }


}