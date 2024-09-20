import org.example.business_logic.Multiplication;
import org.example.data_model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationTest {
    @Test
    public void multiplicationTest() {
        Polynomial p1 = new Polynomial();
        p1.addValue(3, 2);
        p1.addValue(2, 3);
        p1.addValue(1, -1);
        p1.addValue(0, 5);
        Polynomial p2 = new Polynomial();
        p2.addValue(2, 1);
        p2.addValue(1, -4);
        p2.addValue(0, 2);
        Multiplication mul = new Multiplication();
        Polynomial rezultat = new Polynomial();
        rezultat.addValue(5, 2);
        rezultat.addValue(4, -5);
        rezultat.addValue(3, -9);
        rezultat.addValue(2, 15);
        rezultat.addValue(1, -22);
        rezultat.addValue(0, 10);
        try {
            Polynomial resultMul = mul.MultiplicatePolynomials(p1, p2);
            assertEquals(rezultat.getMap(), resultMul.getMap());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
