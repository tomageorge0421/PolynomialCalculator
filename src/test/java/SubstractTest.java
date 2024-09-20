import org.example.business_logic.Substract;
import org.example.data_model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubstractTest {
    @Test
    public void substractTest() {
        Polynomial p1 = new Polynomial();
        p1.addValue(3, 2);
        p1.addValue(2, 3);
        p1.addValue(1, -1);
        p1.addValue(0, 5);
        Polynomial p2 = new Polynomial();
        p2.addValue(2, 1);
        p2.addValue(1, -4);
        p2.addValue(0, 2);
        Substract dif = new Substract();
        Polynomial rezultat = new Polynomial();
        rezultat.addValue(3, 2);
        rezultat.addValue(2, 2);
        rezultat.addValue(1, 3);
        rezultat.addValue(0, 3);
        try {
            Polynomial resultDif = dif.substractPolynomials(p1, p2);
            assertEquals(rezultat.getMap(), resultDif.getMap());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
