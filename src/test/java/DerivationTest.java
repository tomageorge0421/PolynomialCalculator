import org.example.business_logic.Derivation;
import org.example.data_model.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DerivationTest {
    @Test
    public void derivationTest(){
        Polynomial p1 = new Polynomial();
        p1.addValue(3,2);
        p1.addValue(2,3);
        p1.addValue(1,-1);
        p1.addValue(0,5);
        Polynomial rezultat = new Polynomial();
        rezultat.addValue(2,6);
        rezultat.addValue(1,6);
        rezultat.addValue(0,-1);
        Derivation der = new Derivation();
        try {
            Polynomial resultDer = der.DerivatePolynomial(p1);
            Polynomial resultDerAux = new Polynomial();
            for (Map.Entry<Integer, Double> entry1 : resultDer.getMap().descendingMap().entrySet()){
                if(entry1.getValue()!=0){
                    resultDerAux.getMap().put(entry1.getKey(),entry1.getValue());
                }
            }
            assertEquals(rezultat.getMap(), resultDerAux.getMap());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
