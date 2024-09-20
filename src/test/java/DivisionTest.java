import org.example.business_logic.Division;
import org.example.data_model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionTest {
    @Test
    public void divisionTest(){
        Polynomial p1 = new Polynomial();
        p1.addValue(3,2);
        p1.addValue(2,3);
        p1.addValue(1,-1);
        p1.addValue(0,5);
        Polynomial p2 = new Polynomial();
        p2.addValue(2,1);
        p2.addValue(1,-4);
        p2.addValue(0,2);
        Polynomial rezultatCat = new Polynomial();
        rezultatCat.addValue(1,2);
        rezultatCat.addValue(0,11);
        Polynomial rezultatRest = new Polynomial();
        rezultatRest.addValue(1,39);
        rezultatRest.addValue(0,-17);
        Division div = new Division();
        try{
            Polynomial[] vector = new Polynomial[2];
            vector = div.DivPolynomialCat(p1,p2);
            assertEquals(rezultatCat.getMap(), vector[0].getMap());
            assertEquals(rezultatRest.getMap(),vector[1].getMap());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
