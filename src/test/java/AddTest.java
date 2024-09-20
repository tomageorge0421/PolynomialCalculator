import org.example.business_logic.Add;
import org.example.data_model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {
    @Test
    public void addTest() {
        Polynomial p1 = new Polynomial();
        p1.addValue(3, 2);
        p1.addValue(2, 3);
        p1.addValue(1, -1);
        p1.addValue(0, 5);
        Polynomial p2 = new Polynomial();
        p2.addValue(2, 1);
        p2.addValue(1, -4);
        p2.addValue(0, 2);
        Add sum = new Add();
        Polynomial rezultat = new Polynomial();
        rezultat.addValue(3, 2);
        rezultat.addValue(2, 4);
        rezultat.addValue(1, -5);
        rezultat.addValue(0, 7);
        try {
            Polynomial resultSum = sum.addPolynomials(p1, p2);
            assertEquals(rezultat.getMap(), resultSum.getMap());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
